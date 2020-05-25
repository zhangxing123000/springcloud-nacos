package com.zx.controller;

import com.zx.FeignService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getOrder")
    public String getOrder(){
        return "Order";
    }

    @RequestMapping("/getUser")
    public String getUser(){
        return userService.getUser();
    }
}
