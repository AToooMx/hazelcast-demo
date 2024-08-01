package com.hazelcast.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "hazelcast")
public class HazelcastConfigProperties {
    private String clusterName;
}
