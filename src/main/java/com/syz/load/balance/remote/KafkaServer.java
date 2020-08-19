package com.syz.load.balance.remote;

import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("kafkaDemo")
public interface KafkaServer {

    @GetMapping("user/{id}")
    @ApiOperation("输入id，请求用户信息，并发送kafka消息")
    public String getById(@PathVariable("id")Long id);
}
