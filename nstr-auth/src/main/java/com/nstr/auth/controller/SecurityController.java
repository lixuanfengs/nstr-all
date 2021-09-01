package com.nstr.auth.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.nstr.auth.service.ValidateCodeService;
import com.nstr.common.core.exception.NstrRuntimeException;
import com.nstr.common.core.exception.ValidateCodeException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

@RestController
public class SecurityController {

    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @Autowired
    private ValidateCodeService validateCodeService;

    @GetMapping("oauth/test")
    public String testOauth() {
        return "oauth";
    }

    @GetMapping("user")
    public Principal currentUser(Principal principal) {
        return principal;
    }

    @DeleteMapping("signout")
    public R singout(@RequestHeader("Authorization")String authorization) {
        String token = StringUtils.replace(authorization, "bearer ", "");
        if(!consumerTokenServices.revokeToken(token)) {
            throw new NstrRuntimeException("退出登录失败");
        }
        return R.ok("退出登录成功");
    }

    @GetMapping("captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws ValidateCodeException, IOException {
        validateCodeService.create(request, response);
    }
}
