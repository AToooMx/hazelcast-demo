package com.hazelcast.demo.controller;

import com.hazelcast.demo.dto.SaveMessageRequest;
import com.hazelcast.demo.service.CacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cache")
public class DemoController {
    private final CacheService cacheService;

    @PostMapping("/save-message")
    private String saveMessage(@RequestBody SaveMessageRequest request) {
        return cacheService.saveMessage(request);
    }

    @GetMapping("/{key}")
    public String getMessage(@PathVariable String key) {
        return cacheService.getMessageFromCache(key);

    }

    @GetMapping()
    public List<String> getAllMessages() {
        return cacheService.getMessages();

    }

}
