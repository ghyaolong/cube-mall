package com.cube.webadmin.config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author tututu
 * @description
 * @date 2019/9/9 22:58
 * @email 289911401@qq.com
 * @since V1.0.0
 */
public class RedisConfig {

    @Autowired
    JedisConnectionFactory jedisConnectionFactory;


    @Bean
    public JedisPool jedisPool() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(1000);
        jedisConnectionFactory.afterPropertiesSet();
        return new JedisPool(jedisPoolConfig,
                jedisConnectionFactory.getHostName(), jedisConnectionFactory.getPort(),
                jedisConnectionFactory.getTimeout(), jedisConnectionFactory.getPassword());
    }
}
