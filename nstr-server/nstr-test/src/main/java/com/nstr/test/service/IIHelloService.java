package com.nstr.test.service;

import com.nstr.test.service.fallback.HelloServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "nstr-system", contextId = "helloServiceClient", fallbackFactory = HelloServiceFallback.class)
public interface IIHelloService {

    @GetMapping("hello")
    String hello(@RequestParam String name);
}
