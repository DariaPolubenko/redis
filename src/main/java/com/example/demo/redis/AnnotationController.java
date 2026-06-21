package com.example.demo.redis;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/annotation")
public class AnnotationController {

    private AnnotationRedis annotationRedis;

    public AnnotationController(AnnotationRedis annotationRedis) {
        this.annotationRedis =  annotationRedis;
    }

    @PostMapping
    public UserDTO get(@RequestParam int id) throws InterruptedException {
        return annotationRedis.getUserById(id);
    }

    @PutMapping
    public void delete(@RequestParam int id) {
        annotationRedis.deleteUserCache(id);
    }


}
