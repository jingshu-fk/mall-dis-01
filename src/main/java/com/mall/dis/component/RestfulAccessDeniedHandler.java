/**
 * @projectName mall-jing
 * @package com.mall.dis.component
 * @className com.mall.dis.component.RestfulAccessDeniedHandler
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.mall.dis.component;

import cn.hutool.json.JSONUtil;
import com.mall.dis.common.api.CommonResult;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * RestfulAccessDeniedHandler
 * &#064;description  当访问接口没有权限时，自定义的返回结果
 * @author shujingping
 * &#064;date  2022/9/24 16:06
 * @version 1.0
 */
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException e) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(JSONUtil.parse(CommonResult.forbidden(e.getMessage())));
        response.getWriter().flush();
    }
}
