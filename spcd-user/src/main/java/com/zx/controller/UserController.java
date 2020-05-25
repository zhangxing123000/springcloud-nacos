package com.zx.controller;


import com.zx.FeignService.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private OrderService orderService;

    @Value("${param.config}")
    private String config;

    @GetMapping("/helloUser")
    public String helloUser() {
        return "hello User ,param.config = " + config;

    }

    @RequestMapping("/getOrder")
    public String getOrder(){
        return orderService.getOrder();
    }

}
