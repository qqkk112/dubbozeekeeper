package com.reger.test.provider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.alibaba.dubbo.config.annotation.Service;
import com.reger.test.exception.TestRuntimeException;
import com.test.dubbo.model.User;
import com.test.dubbo.service.MathService;

@Service(protocol="dubbo-hessian")
public class MathServiceImpl implements MathService {

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
}
