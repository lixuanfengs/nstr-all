package com.nstr.auth.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@SpringBootConfiguration
@Data
@PropertySource(value = {"classpath:nstr-auth.properties"})
@ConfigurationProperties(prefix = "nstr.auth")
public class NstrAuthProperties {

    private NstrClientProperties[] clients = {};
    private int accessTokenValiditySeconds = 60 * 60 * 24;
    private int refreshTokenValiditySeconds = 60 * 60 * 24 * 7;

    //免密认证路径
    private String anonUrl;

    //验证码配置类
    private NstrValidateCodeProperties code = new NstrValidateCodeProperties();
}
