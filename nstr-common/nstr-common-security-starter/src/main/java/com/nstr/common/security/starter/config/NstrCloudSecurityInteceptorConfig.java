package com.nstr.common.security.starter.config;

import com.nstr.common.security.starter.interceptor.NstrServerProtectInterceptor;
import com.nstr.common.security.starter.properties.NstrCloudSecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: cactusli
 * @date: 2021.08.17
 */
public class NstrCloudSecurityInteceptorConfig implements WebMvcConfigurer {

    private NstrCloudSecurityProperties properties;

    @Autowired
    public void setProperties(NstrCloudSecurityProperties properties) {
        this.properties = properties;
    }

    @Bean
    public HandlerInterceptor nstrServerProtectInterceptor() {
        NstrServerProtectInterceptor NstrServerProtectInterceptor = new NstrServerProtectInterceptor();
        NstrServerProtectInterceptor.setProperties(properties);
        return NstrServerProtectInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(nstrServerProtectInterceptor());
    }
}
