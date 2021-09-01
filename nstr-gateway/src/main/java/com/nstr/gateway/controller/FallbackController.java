package com.nstr.gateway.controller;

import com.nstr.common.core.utils.NstrResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author: cactusli
 * @date: 2021.08.18
 */
@RestController
public class FallbackController {

    @RequestMapping(("fallback/{name}"))
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Mono<NstrResponse> systemFallback(@PathVariable String name) {
        String response = String.format("访问%s超时或者服务不可用", name);
        return Mono.just(new NstrResponse().message(response));
    }
}
