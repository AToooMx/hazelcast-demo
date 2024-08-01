package com.hazelcast.demo.service;

import com.hazelcast.demo.dto.SaveMessageRequest;

import java.util.List;

public interface CacheService {

    String saveMessage(SaveMessageRequest request);

    String getMessageFromCache(String key);

    List<String> getMessages();
}
