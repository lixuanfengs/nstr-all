package com.nstr.common.security.starter.handler;


import com.nstr.common.core.utils.NstrUtils;
import com.nstr.common.core.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: cactusli
 * @date: 2021.08.17
 */
@Slf4j
public class NstrAuthExceptionEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {

        String requestURI = request.getRequestURI();
        int status = HttpServletResponse.SC_UNAUTHORIZED;
        String message = "访问令牌不合法";
        log.error("客户端访问{}请求失败: {}", requestURI, message, authException);

        NstrUtils.makeJsonResponse(response, status, R.error(HttpServletResponse.SC_UNAUTHORIZED, message));
    }
}
