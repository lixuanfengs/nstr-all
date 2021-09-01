package com.nstr.common.security.starter.annotaion;

import com.nstr.common.security.starter.config.NstrCloudResourceServerConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author: cactusli
 * @date: 2021.08.17
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(NstrCloudResourceServerConfig.class)
public @interface EnableNstrCloudResourceServer {
}
