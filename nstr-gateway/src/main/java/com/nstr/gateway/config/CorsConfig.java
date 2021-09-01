package com.nstr.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {

    @Bean
    public CorsWebFilter corsWebFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        org.springframework.web.cors.CorsConfiguration corsConfiguration = new org.springframework.web.cors.CorsConfiguration();
        // 1.配置跨域
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedHeader(org.springframework.web.cors.CorsConfiguration.ALL);
        corsConfiguration.addAllowedOrigin(org.springframework.web.cors.CorsConfiguration.ALL);
        corsConfiguration.addAllowedMethod(org.springframework.web.cors.CorsConfiguration.ALL);
        source.registerCorsConfiguration("/**", corsConfiguration);
        return  new CorsWebFilter(source);
    }
}
