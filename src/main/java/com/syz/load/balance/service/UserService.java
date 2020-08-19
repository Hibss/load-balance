package com.syz.load.balance.service;

import com.syz.load.balance.dao.UserMapper;
import com.syz.load.balance.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getById(Long id) {
        log.info("UserService getById :{}" ,id);
        return userMapper.selectByPrimaryKey(id);
    }
}
