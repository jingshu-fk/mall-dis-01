/**
 * @projectName mall-jing
 * @package com.mall.dis.component
 * @className com.mall.dis.component.RestAuthenticationEntryPoint
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.mall.dis.component;

import cn.hutool.json.JSONUtil;
import com.mall.dis.common.api.CommonResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * RestAuthenticationEntryPoint
 * @description 当未登录或者token失效访问接口时，自定义的返回结果
 * @author shujingping
 * @date 2022/9/24 16:13
 * @version 1.0
 */
@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(JSONUtil.parse(CommonResult.unauthorized(authException.getMessage())));
        response.getWriter().flush();
    }
}
