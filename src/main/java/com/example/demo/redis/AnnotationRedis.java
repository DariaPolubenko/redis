package com.example.demo.redis;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Cacheable
public class AnnotationRedis {

    @Cacheable(value = "users", key = "#id")
    public UserDTO getUserById(int id) throws InterruptedException {
        System.out.println("Идем в БД " + "id " + id);
        System.out.println("Спит..");
        Thread.sleep(5000);
        return new UserDTO("Иван", "123");
    }

    @CacheEvict(value = "users", key = "#id")
    public void deleteUserCache(int id) {
        System.out.println("Пользователь очищен");
    }

    @CachePut(value = "users", key="#id")
    public void update(int id) {
        System.out.println("User обновлен");
    }

}
