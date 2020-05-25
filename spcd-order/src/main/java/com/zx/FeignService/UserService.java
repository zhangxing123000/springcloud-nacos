package com.zx.FeignService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@FeignClient("spcd-user")
public interface UserService {

    @RequestMapping("/user/helloUser")
    String getUser();
}
