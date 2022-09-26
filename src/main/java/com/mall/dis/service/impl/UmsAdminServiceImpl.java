/**
 * @projectName mall-jing
 * @package com.mall.dis.service.impl
 * @className com.mall.dis.service.impl.UmsAdminServiceImpl
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.mall.dis.service.impl;

import com.mall.dis.common.utils.JwtTokenUtil;
import com.mall.dis.entity.UmsAdmin;
import com.mall.dis.entity.UmsPermission;
import com.mall.dis.mapper.UmsAdminMapper;
import com.mall.dis.mapper.UmsAdminRoleRelationMapper;
import com.mall.dis.service.UmsAdminService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * UmsAdminServiceImpl
 * @description UmsAdminService实现类
 * @author shujingping
 * @date 2022/9/26 21:38
 * @version 1.0
 */
public class UmsAdminServiceImpl implements UmsAdminService {
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(UmsAdminServiceImpl.class);

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${jwt.tokenHead")
    private String tokenHead;

    @Autowired
    private UmsAdminMapper umsAdminMapper;

    @Autowired
    private UmsAdminRoleRelationMapper umsAdminRoleRelationMapper;


    /**
     *
     * @param username
     * @return
     */
    @Override
    public UmsAdmin getAdminBymUsername(String username) {
        return null;
    }

    /**
     *
     * @param umsAdminParam
     * @return
     */
    @Override
    public UmsAdmin register(UmsAdmin umsAdminParam) {
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(umsAdminParam, umsAdmin);
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(1);

        return null;
    }

    /**
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getUsername())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities()
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            LOGGER.warning(e.getMessage());
        }
        return token;
    }

    /**
     *
     * @param adminId
     * @return
     */
    @Override
    public List<UmsPermission> getPermissionList(Long adminId) {
        return null;
    }
}
