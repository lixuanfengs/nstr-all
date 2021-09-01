package com.nstr.common.security.starter.interceptor;

import com.nstr.common.core.constant.NstrConstant;
import com.nstr.common.core.utils.NstrResponse;
import com.nstr.common.core.utils.NstrUtils;
import com.nstr.common.security.starter.properties.NstrCloudSecurityProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.NonNull;
import org.springframework.util.Base64Utils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: cactusli
 * @date: 2021.08.17
 */
public class NstrServerProtectInterceptor implements HandlerInterceptor {

    private NstrCloudSecurityProperties properties;

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception {
        if(!properties.getOnlyFetchByGateway()) {
            return true;
        }
        String token = request.getHeader(NstrConstant.GATEWAY_TOKEN_HEADER);
        String gatewayToken = new String(Base64Utils.encode(NstrConstant.GATEWAY_TOKEN_VALUE.getBytes()));

        if (StringUtils.equals(gatewayToken, token)) {
            return true;
        } else {
            NstrResponse febsResponse = new NstrResponse();
            NstrUtils.makeJsonResponse(response, HttpServletResponse.SC_FORBIDDEN, febsResponse.message("请通过网关获取资源"));
            return false;
        }
    }

    public void setProperties(NstrCloudSecurityProperties properties) {
        this.properties = properties;
    }
}
