package com.example.aws;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @GetMapping("/")
    @ResponseBody
    public String test(){
        return "hello_aws";
    }
}
