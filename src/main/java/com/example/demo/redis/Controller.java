package com.example.demo.redis;

import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/redis")
public class Controller {
    public RedisService redisService;

    public record RedisRequest(String key, String value) {}

    public Controller(RedisService redisService) {
        this.redisService =  redisService;
    }

    @PostMapping()
    public String save(@RequestBody RedisRequest redis) {
        redisService.save(redis.key, redis.value);
        return "Успешно создан объект";
    }

    @GetMapping()
    public String get(@RequestParam String key) {
        return redisService.getData(key);
    }

    @PutMapping()
    public String delete(@RequestParam String key) {
        redisService.delete(key);
        return "Успешно удален";
    }
}
