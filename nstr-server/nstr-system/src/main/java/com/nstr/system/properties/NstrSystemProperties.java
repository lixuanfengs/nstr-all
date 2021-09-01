package com.nstr.system.properties;


import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:nstr-system.properties"})
@ConfigurationProperties(prefix = "nstr.system")
public class NstrSystemProperties {

    /**
     * 免认证 URI，多个值的话以逗号分隔
     */
    private String anonUrl;

    private NstrSwaggerProperties swagger = new NstrSwaggerProperties();
}
