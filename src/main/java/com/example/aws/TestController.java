package com.example.aws;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestRepository testRepository;
    @GetMapping("/")
    public String test() {
        TestEntity entity = testRepository.findById(1L).orElse(null);
        return entity.name+":"+entity.password;
    }
}
