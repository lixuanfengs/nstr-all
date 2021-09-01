package com.nstr.test.service.fallback;
import com.nstr.test.service.IIHelloService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HelloServiceFallback implements FallbackFactory<IIHelloService> {
    @Override
    public IIHelloService create(Throwable throwable) {
        return name -> {
            log.error("调用 nstr-system 服务出错", throwable);
            return "调用出错";
        };
    }
}
