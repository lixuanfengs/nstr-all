package com.nstr.auth.handler;

import com.nstr.common.core.utils.NstrResponse;
import com.nstr.common.core.utils.NstrUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: cactusli
 * @date: 2021.08.17
 */
@Component
public class NstrWebLoginFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        String message;
        if (e instanceof BadCredentialsException) {
            message = "用户名或密码错误！";
        } else if (e instanceof LockedException) {
            message = "用户已被锁定！";
        } else {
            message = "认证失败，请联系网站管理员！";
        }
        NstrResponse febsResponse = new NstrResponse().message(message);
        NstrUtils.makeFailureResponse(httpServletResponse, febsResponse);
    }
}
