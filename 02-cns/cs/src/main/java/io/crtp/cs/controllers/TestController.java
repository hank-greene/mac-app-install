package io.crtp.cs.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private static final String template = "Test, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/test")
    public Test test(@RequestParam(defaultValue = "default msg") String msg) {
        return new Test(counter.incrementAndGet(), template.formatted(msg));
    }
    
}
