package com.nstr.common.security.starter.config;

import com.nstr.common.core.constant.NstrConstant;
import com.nstr.common.core.utils.NstrUtils;
import com.nstr.common.security.starter.handler.NstrAccessDeniedHandler;
import com.nstr.common.security.starter.handler.NstrAuthExceptionEntryPoint;
import com.nstr.common.security.starter.properties.NstrCloudSecurityProperties;
import feign.RequestInterceptor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.util.Base64Utils;

/**
 * @author: cactusli
 * @date: 2021.08.17
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableConfigurationProperties(NstrCloudSecurityProperties.class)
@ConditionalOnProperty(value = "nstr.cloud.security.enable", havingValue = "true", matchIfMissing = true)
public class NstrCloudSecurityAutoConfig extends GlobalMethodSecurityConfiguration {

    @Bean
    @ConditionalOnMissingBean(name = "accessDeniedHandler")
    public NstrAccessDeniedHandler accessDeniedHandler() {
        return new NstrAccessDeniedHandler();
    }

    @Bean
    @ConditionalOnMissingBean(name = "authenticationEntryPoint")
    public NstrAuthExceptionEntryPoint authenticationEntryPoint() {
        return new NstrAuthExceptionEntryPoint();
    }

    @Bean
    @ConditionalOnMissingBean(value = PasswordEncoder.class)
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public NstrCloudSecurityInteceptorConfig febsCloudSecurityInteceptorConfigure() {
        return new NstrCloudSecurityInteceptorConfig();
    }

    @Bean
    @Primary
    @ConditionalOnMissingBean(DefaultTokenServices.class)
    public NstrUserInfoTokenServices febsUserInfoTokenServices(ResourceServerProperties properties) {
        return new NstrUserInfoTokenServices(properties.getUserInfoUri(), properties.getClientId());
    }

    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor() {
        return requestTemplate -> {
            String gatewayToken = new String(Base64Utils.encode(NstrConstant.GATEWAY_TOKEN_VALUE.getBytes()));
            requestTemplate.header(NstrConstant.GATEWAY_TOKEN_HEADER, gatewayToken);
            String authorizationToken = NstrUtils.getCurrentTokenValue();
            if (StringUtils.isNotBlank(authorizationToken)) {
                requestTemplate.header(HttpHeaders.AUTHORIZATION, NstrConstant.OAUTH2_TOKEN_TYPE + authorizationToken);
            }
        };
    }

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        return new OAuth2MethodSecurityExpressionHandler();
    }

}
