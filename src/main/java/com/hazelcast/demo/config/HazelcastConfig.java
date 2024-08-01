package com.hazelcast.demo.config;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(HazelcastConfigProperties.class)
public class HazelcastConfig {
    private final HazelcastConfigProperties properties;

    @Bean
    public Config config() {
        var config = new Config();
        config.setClusterName(properties.getClusterName());
        return config;
    }

    @Bean
    public HazelcastInstance instance() {
        return Hazelcast.newHazelcastInstance(config());
    }

    @Bean
    public IMap<String, String> messagesIMap() {
        return instance().getMap("messageMap");
    }
}
