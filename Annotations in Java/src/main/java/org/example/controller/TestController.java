package org.example.controller;

import org.example.model.RateLimit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RateLimit(limit = 3)
    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
