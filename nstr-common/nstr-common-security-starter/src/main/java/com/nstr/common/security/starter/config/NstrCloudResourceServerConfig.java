package com.nstr.common.security.starter.config;

import com.nstr.common.core.constant.EndpointConstant;
import com.nstr.common.core.constant.StringConstant;
import com.nstr.common.security.starter.handler.NstrAccessDeniedHandler;
import com.nstr.common.security.starter.handler.NstrAuthExceptionEntryPoint;
import com.nstr.common.security.starter.properties.NstrCloudSecurityProperties;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author: cactusli
 * @date: 2021.08.17
 */
@EnableResourceServer
@EnableAutoConfiguration(exclude = UserDetailsServiceAutoConfiguration.class)
public class NstrCloudResourceServerConfig extends ResourceServerConfigurerAdapter {

    private NstrCloudSecurityProperties properties;
    private NstrAccessDeniedHandler accessDeniedHandler;
    private NstrAuthExceptionEntryPoint authExceptionEntryPoint;

    @Autowired(required = false)
    public void setProperties(NstrCloudSecurityProperties properties) {
        this.properties = properties;
    }

    @Autowired(required = false)
    public void setAccessDeniedHandler(NstrAccessDeniedHandler accessDeniedHandler) {
        this.accessDeniedHandler = accessDeniedHandler;
    }

    @Autowired(required = false)
    public void setAuthExceptionEntryPoint(NstrAuthExceptionEntryPoint authExceptionEntryPoint) {
        this.authExceptionEntryPoint = authExceptionEntryPoint;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        if(properties == null) {
            permitAll(http);
            return;
        }
        String[] anonUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens(properties.getAnonUris(), StringConstant.COMMA);
        if(ArrayUtils.isEmpty(anonUrls)){
            anonUrls = new String[]{};
        }
        if(ArrayUtils.contains(anonUrls, EndpointConstant.ALL)) {
            permitAll(http);
            return;
        }
        http.csrf().disable()
                .requestMatchers().antMatchers(properties.getAuthUri())
                .and()
                .authorizeRequests()
                .antMatchers(anonUrls).permitAll()
                .antMatchers(properties.getAuthUri()).authenticated()
                .and()
                .httpBasic();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {

        if (authExceptionEntryPoint != null) {
            resources.authenticationEntryPoint(authExceptionEntryPoint);
        }
        if (accessDeniedHandler != null) {
            resources.accessDeniedHandler(accessDeniedHandler);
        }
    }

    private void permitAll(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().anyRequest().permitAll();
    }
}
