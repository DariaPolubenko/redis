package com.example.demo.redis.config;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Service
public class RedisConfig {

//    @Bean
//    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(factory);
//        return redisTemplate;
//    }
//
//    public CacheManager cacheManager() {
//        return new RedisCacheManager.builder;
//    }

    @Bean
    public RedisCacheManager redisCacheManager(RedisConnectionFactory redisConnectionFactory) { //под каждую категорию кэша можно настроить разный ttl
        RedisCacheConfiguration products = RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(50)).disableCachingNullValues();

        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(10)).disableCachingNullValues();  //настройка времени жизни кэша (10 мин_
        Map<String, RedisCacheConfiguration> map = new HashMap<>();
        map.put("products", products);
        map.put("redis_cache2", redisCacheConfiguration);
        System.out.println("тест");

        return RedisCacheManager.builder(redisConnectionFactory).cacheDefaults(redisCacheConfiguration).withInitialCacheConfigurations(map).build();

    }
}
