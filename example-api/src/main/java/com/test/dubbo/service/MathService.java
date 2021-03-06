package com.test.dubbo.service;

import java.util.List;

import com.test.dubbo.common.Wrapper;
import com.test.dubbo.model.User;
import org.springframework.web.bind.annotation.RequestParam;

public interface MathService {
	
	/**
	 * 简单示例
	 * @param a
	 * @param b
	 * @return
	 */
	Integer add(Integer a,Integer b);
	
	/**
	 * 复杂对象示例
	 * @param args
	 * @return
	 */
	List<Object> toList(Object ... args);
	
	/**
	 * 抛出异常测试
	 */
	void throwThrowable();
	
	User getUser(User user);

	String getList();

	Wrapper list(Integer page, Integer size);
}
