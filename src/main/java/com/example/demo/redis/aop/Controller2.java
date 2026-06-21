package com.example.demo.redis.aop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller2 {
    public Service2 service;
    
    public Controller2(Service2 service) {
        this.service = service;
    }
    
    @GetMapping("/data")
    public String getData(@RequestParam int id) {
        return service.getUserData(id);
    }


}
