package com.nstr.auth;


import com.nstr.common.core.annotation.EnableNstrLettuceRedis;
import com.nstr.common.security.starter.annotaion.EnableNstrCloudResourceServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableNstrLettuceRedis
//@EnableDiscoveryClient 因为Nacos不需要这个注解也能开启服务注册与发现。
@SpringBootApplication
@EnableNstrCloudResourceServer
@MapperScan("com.nstr.auth.mapper")
public class NstrAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(NstrAuthApplication.class, args);
    }

}
