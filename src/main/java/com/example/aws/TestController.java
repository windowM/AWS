package com.example.aws;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class TestController {

    private final TestRepository testRepository;

    @GetMapping("/")
    @ResponseBody
    public String test() {
        TestEntity entity= testRepository.findById(1L).orElse(null);
        return entity.getName()+":"+entity.getPassword();
    }
}
