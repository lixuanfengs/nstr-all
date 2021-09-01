package com.nstr.system;

import com.nstr.common.security.starter.annotaion.EnableNstrCloudResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAsync
@SpringBootApplication
@EnableDiscoveryClient
@EnableNstrCloudResourceServer
@EnableTransactionManagement
public class NstrSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(NstrSystemApplication.class, args);
    }

}
