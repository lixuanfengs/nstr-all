package com.nstr.common.core.annotation;


import com.nstr.common.core.config.NstrLettuceRedisConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(NstrLettuceRedisConfig.class)
public @interface EnableNstrLettuceRedis {
}
