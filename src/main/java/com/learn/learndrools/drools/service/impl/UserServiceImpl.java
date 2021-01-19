package com.learn.learndrools.drools.service.impl;

import com.learn.learndrools.drools.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void save(Integer count) {
        System.out.println("userService save方法");
    }
}
