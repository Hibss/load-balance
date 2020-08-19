package com.syz.load.balance.rule;

import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DiyLoadBalanceRule {
    @Bean
    public IRule ribbonRule() {
//        return new RoundRobinRule();                //轮询
//         return new WeightedResponseTimeRule();    //加权权重
//        return new RetryRule();                    //带有重试机制的轮训
//        return new RandomRule();                   //随机
        return new DiyRule();                     //自定义规则
    }
}
