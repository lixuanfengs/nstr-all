package com.nstr.auth.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.nstr.common.core.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.units.qual.C;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.security.oauth2.common.exceptions.InvalidClientException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author: cactusli
 * @date: 2021.09.01
 */
@Slf4j
@Service
public class RedisClientDetailsService extends JdbcClientDetailsService {

    /**
     * 缓存 client的 redis key，这里是 hash结构存储
     */
    private static final String CACHE_CLIENT_KEY = "client_details";

    private final RedisService redisService;

    public RedisClientDetailsService(DataSource dataSource, RedisService redisService) {
        super(dataSource);
        this.redisService = redisService;
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws InvalidClientException {
        ClientDetails clientDetails = null;
        String value = (String) redisService.hget(CACHE_CLIENT_KEY, clientId);
        if(StringUtils.isBlank(value)) {
            clientDetails = cacheAndGetClient(clientId);
        } else {

        }
        return super.loadClientByClientId(clientId);
    }

    public ClientDetails cacheAndGetClient(String clientId) {
        ClientDetails clientDetails = null;
        clientDetails = super.loadClientByClientId(clientId);
        if(clientDetails != null) {
            BaseClientDetails baseClientDetails = (BaseClientDetails) clientDetails;
            Set<String> autoApproveScopes = baseClientDetails.getAutoApproveScopes();
            if(CollectionUtils.isNotEmpty(autoApproveScopes)) {
                baseClientDetails.setAutoApproveScopes(
                        autoApproveScopes.stream().map(this::convert).collect(Collectors.toSet())
                );
            }
            redisService.hset(CACHE_CLIENT_KEY, clientId, JSONObject.toJSONString(baseClientDetails));
        }
        return clientDetails;
    }

    /**
     * 删除 redis缓存
     *
     * @param clientId clientId
     */
    public void removeRedisCache(String clientId) {
        redisService.hdel(CACHE_CLIENT_KEY, clientId);
    }

    private String convert(String value) {
        final String logicTrue = "1";
        return logicTrue.equals(value) ? Boolean.TRUE.toString() : Boolean.FALSE.toString();
    }
}
