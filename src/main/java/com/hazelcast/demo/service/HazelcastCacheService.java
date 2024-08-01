package com.hazelcast.demo.service;

import com.hazelcast.demo.dto.SaveMessageRequest;
import com.hazelcast.demo.exception.NotFoundException;
import com.hazelcast.map.IMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class HazelcastCacheService implements CacheService {
    private final IMap<String, String> messageMap;

    @Override
    public String saveMessage(SaveMessageRequest request) {
        var key = hash();
        messageMap.put(key, request.getMessage());
        return key;
    }

    @Override
    public String getMessageFromCache(String key) {
        if(!messageMap.containsKey(key)) {
            throw new NotFoundException("Not found message. key: " + key);
        }
        return messageMap.get(key);
    }

    @Override
    public List<String> getMessages() {
        if(messageMap.isEmpty()) {
            return new ArrayList<>();
        }
        return new ArrayList<>(messageMap.values());
    }

    private String hash() {
        return DigestUtils.sha256Hex(UUID.randomUUID().toString());
    }
}
