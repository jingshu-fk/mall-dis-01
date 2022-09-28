package com.mall.dis.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.mall.dis.common.Const.CLAIM_KEY_CREATED;
import static com.mall.dis.common.Const.CLAIM_KEY_USERNAME;

/**
 * JwtToken生成的工具类
 * @author shujingping
 */

@Component
public class JwtTokenUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private String expiration;

    /**
     * 根据负载生成JWT的token
     */
    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 从token中获取JWT中的负载
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            LOGGER.info("JWT格式验证失败:{}", token);
        }
        return claims;
    }

    /**
     * 生成token的过期时间
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + Integer.parseInt(expiration) * 1000L);
    }

    /**
     * 从token中获取登录用户名
     */
    public String getUserNameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    /**
     * 验证token是否还有效
     *
     * @param token       客户端传入的token
     * @param userDetails 从数据库中查询出来的用户信息
     */
    public boolean validateToken(String token, UserDetails userDetails) {
        String username = getUserNameFromToken(token);
        return username.equals(userDetails.getUsername()) && isTokenExpired(token);

    }

    public boolean isTokenExpired(String token) {
        Date expiredDate = getExpiredDateFromToken(token);
        return !expiredDate.before(new Date());
    }

    public Date getExpiredDateFromToken(String token) {
        /**
         * @description 从token获取过期时间
         * @param token
         * @return java.util.Date
         * @date 2022/9/24 15:44
         * @author shujingping
         */
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }

    public String generateToken(UserDetails userDetails) {
        /**
         * @description 根据用户信息生产token
         * @param userDetails
         * @return java.lang.String
         * @date 2022/9/24 15:50
         * @author shujingping
         */
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    public boolean canRefresh(String token) {
        /**
         * @description 判断验证码是否能更新
         * @param token
         * @return boolean
         * @date 2022/9/24 15:54
         * @author shujingping
         */
        return isTokenExpired(token);
    }

    public String refreshToken(String token) {
        /**
         * @description 刷新token
         * @param token
         * @return java.lang.String
         * @date 2022/9/24 15:57
         * @author shujingping
         */
        Claims claims = getClaimsFromToken(token);
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }
}
