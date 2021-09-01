package com.nstr.test;

import com.nstr.common.security.starter.annotaion.EnableNstrCloudResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableNstrCloudResourceServer
@EnableFeignClients
public class NstrTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(NstrTestApplication.class, args);
    }

}
