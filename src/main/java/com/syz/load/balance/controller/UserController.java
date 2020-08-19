package com.syz.load.balance.controller;

import com.syz.load.balance.entity.User;
import com.syz.load.balance.remote.KafkaServer;
import com.syz.load.balance.service.UserService;
import com.syz.load.balance.utils.JacksonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@Api(tags = "用户接口")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private KafkaServer kafkaServer;

    @SneakyThrows
    @GetMapping("{id}")
    @ApiOperation("输入id，请求用户信息，并发送kafka消息")
    public User getById(@PathVariable("id")Long id){
//        User user = userService.getById(id);
        String userJson = kafkaServer.getById(id);
        return JacksonUtil.json2pojo(userJson,User.class);
    }
}
