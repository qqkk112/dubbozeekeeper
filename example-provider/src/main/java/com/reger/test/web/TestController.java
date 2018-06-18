package com.reger.test.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class TestController {

    @RequestMapping("/word")
    public String getWord(){
        return "hell word";
    }

}
