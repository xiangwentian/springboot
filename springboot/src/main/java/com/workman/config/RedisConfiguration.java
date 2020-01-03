package com.workman.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description TODO
 * @Auth 向问天
 * @Date 2020/1/3 10:04
 * @Version 1.0
 */
@Slf4j
@Configuration
@EnableCaching
public class RedisConfiguration extends CachingConfigurerSupport {

    public RedisConfiguration() {
        log.info("init RedisConfiguration...");
    }

    @Resource
    private LettuceConnectionFactory lettuceConnectionFactory;

    @Bean
    @Override
    public KeyGenerator keyGenerator() {
        //return super.keyGenerator();
        return new KeyGenerator() {

            @Override
            public Object generate(Object o, Method method, Object... objects) {
                //formating cache key str
                StringBuilder sb = new StringBuilder();
                //append class name
                sb.append(o.getClass().getName());
                //apppend method name
                sb.append(method.getName());
                //traverse params and append
                for (Object obj : objects) {
                    sb.append(obj.toString());
                }
                //log.info("invoke redis cache key:", sb.toString());
                return sb.toString();
            }
        };
    }

    /**
     * cache manager
     *
     * @return
     */
    @Bean
    public CacheManager cacheManager() {
        RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager.RedisCacheManagerBuilder.fromConnectionFactory(lettuceConnectionFactory);

        Set<String> cacheNames = new HashSet<String>() {
            {
                add("codeNameCache");
            }
        };
        builder.initialCacheNames(cacheNames);
        return builder.build();
    }

    @Bean
    public RedisTemplate<String, Serializable> redisTemplate(LettuceConnectionFactory lettuceConnectionFactory) {
        RedisTemplate<String, Serializable> template = new RedisTemplate<>();
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());//hash key serialize
        template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());//hash value serialize
        template.setConnectionFactory(lettuceConnectionFactory);
        return template;
    }
}
