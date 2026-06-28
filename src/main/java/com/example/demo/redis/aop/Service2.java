package com.example.demo.redis.aop;

import com.example.demo.redis.aop.annotations.LogExecutionTime;
import org.springframework.stereotype.Service;

@Service
public class Service2 {
    @LogExecutionTime
    public String getUserData(int id) {
        return "Данные пользователя с id  " + id;
    }
}
