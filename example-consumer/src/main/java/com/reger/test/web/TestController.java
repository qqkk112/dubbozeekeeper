package com.reger.test.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.reger.dubbo.annotation.Inject;
import com.test.dubbo.common.WrapMapper;
import com.test.dubbo.common.Wrapper;
import com.test.dubbo.service.MathService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class TestController {


    // 使用兼容注入
    @Inject
    public MathService bidService;

    @GetMapping("/hello")
    public String hello() {
        return bidService.add(33,55).toString();
    }

    @GetMapping("/list")
    public String list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        return bidService.getList();
    }
}
