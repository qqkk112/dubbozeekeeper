package com.reger.test.provider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.reger.test.exception.TestRuntimeException;
import com.reger.test.service.UserService;
import com.test.dubbo.common.WrapMapper;
import com.test.dubbo.common.Wrapper;
import com.test.dubbo.model.User;
import com.test.dubbo.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service(protocol="dubbo-jvm",registry="test")
public class MathServiceImpl implements MathService {

	@Autowired
	private UserService userService;

	@Override
	public Integer add( Integer a, Integer b) {
		System.err.println("请求到达  " + a + "+" + b + "=" + (a + b));
		return a + b;
	}

	@Override
	public List<Object> toList(Object... args) {
		List<Object> list = new ArrayList<Object>();
		Collections.addAll(list, args);
		System.err.println("返回的数据"+list);
		return list;
	}
	@Override
	public void throwThrowable() {
		throw new TestRuntimeException("专门抛出一个异常试试异常时！");
	}

	@Override
	public User getUser(User user) {
		System.err.println("请求到达  " +user);
		return user;
	}

    @Override
    public String getList() {
		return JSON.toJSONString(userService.selectAll());
    }

    @GetMapping("/list")
	public Wrapper list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
		PageHelper.startPage(page, size);
		List<com.reger.test.model.User> list = userService.selectAll();
		PageInfo pageInfo = new PageInfo(list);
		return WrapMapper.genSuccessResult(pageInfo);
	}
}
