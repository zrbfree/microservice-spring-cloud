package com.itmuch.cloud.microserviceprovideruser.controller;

import com.itmuch.cloud.microserviceprovideruser.entity.User;
import com.itmuch.cloud.microserviceprovideruser.repository.UserRepository;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/********************************************************
 *@Desc:
 *@Author: ZRP
 *@Date: 2017/12/18 11:57
 *****
 * ***************************************************/

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;


    @GetMapping("/simple/{id}")
    public User findById(@PathVariable Long id){
        return userRepository.findOne(id);
    }


    @GetMapping("/eureka-instance")
    public String serviceUrl(){
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("MICROSERVICE-PROVIDER-USER", false);
        return instance.getHomePageUrl();
    }

    /**
     * @Desc :  本地服务实例消息
     * @Author : ZRP
     * @Params:
     * @Return:
     * @Date : 2017/12/19 18:08
     */
    @GetMapping("/instance-info")
    public ServiceInstance instanceInfo(){
        ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
        return localServiceInstance;
    }

    @GetMapping("/serviceAllUrl")
    public String serviceAllUrl(){
        List<ServiceInstance> list = discoveryClient.getInstances("MICROSERVICE-PROVIDER-USER");
        if(list != null && list.size() > 0){
            return list.get(0).getUri().toString();
        }
        return null;
    }




}
