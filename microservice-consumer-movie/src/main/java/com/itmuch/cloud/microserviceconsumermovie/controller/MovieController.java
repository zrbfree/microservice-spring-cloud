package com.itmuch.cloud.microserviceconsumermovie.controller;

import com.itmuch.cloud.microserviceconsumermovie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/********************************************************
 *@Desc: 电影消费者
 *@Author: ZRP
 *@Date: 2017/12/18 12:15
 ********************************************************/
@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${user.userServicePath}")
    private String userServicePath;

    @GetMapping(value = "/movie/{id}")
    public User findById(@PathVariable Long id){
        return restTemplate.getForObject(this.userServicePath + id, User.class);
    }

}
