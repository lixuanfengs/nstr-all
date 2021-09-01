package com.nstr.common.security.starter.handler;

import com.nstr.common.core.utils.NstrUtils;
import com.nstr.common.core.utils.R;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: cactusli
 * @date: 2021.08.17
 */
public class NstrAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse response,
                       AccessDeniedException e) throws IOException, ServletException {
        NstrUtils.makeJsonResponse(response, HttpServletResponse.SC_FORBIDDEN, R.error(HttpServletResponse.SC_FORBIDDEN, "没有权限访问该资源"));
    }
}
