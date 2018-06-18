package com.reger.test.service.impl;


import com.reger.test.mapper.UserMapper;
import com.reger.test.model.User;
import com.reger.test.service.UserService;
import com.reger.test.core.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Tian Jiguang on 2018/06/18.
 */
@Service
@Transactional
public class UserServiceImpl extends BaseService<User> implements UserService {
    @Resource
    private UserMapper userMapper;

}
