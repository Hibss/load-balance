package com.syz.load.balance.rule;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class DiyRule implements IRule {

    private ILoadBalancer iLoadBalancer;

    /**
     *
     */
    private int total = 0;
    /**
     * 当前提供服务列表的索引
     */
    private int currentIndex = 0;

    @Override
    public Server choose(Object o) {
        //1.随机服务节点
//        List<Server> allServers = iLoadBalancer.getAllServers();
//        int index = (int) (Math.random() * allServers.size());
//        log.info("all server size:{} , choose :{}",allServers.size(),index);
//        return allServers.get(index);
        //2。轮询获取服务节点
        Server server = null;
        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            // 获取可用服务列表
            List<Server> upList = iLoadBalancer.getReachableServers();
            total = upList.size();
            if (total == 0) {
                return null;
            }
            if(currentIndex < total)
            {
                server = upList.get(currentIndex);
            } else {
                currentIndex = 0;
                server = upList.get(currentIndex);
            }
            currentIndex++;
            Thread.yield();
            log.info("all server size:{} , choose :{}",total,currentIndex);
        }
        return server;
    }

    @Override
    public void setLoadBalancer(ILoadBalancer iLoadBalancer) {
        this.iLoadBalancer = iLoadBalancer;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return iLoadBalancer;
    }
}
