package com.xh.controller;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * RedisController
 *
 * @author xiaohe
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    public static final String KEY = "test_key";

    public StringRedisTemplate stringRedisTemplate;

    public RedisController(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @PostMapping("setValue")
    public String setValue(String value) {
        if (StringUtils.isEmpty(StringUtils.trimWhitespace(value))) {
            return "value is null";
        }
        stringRedisTemplate.opsForValue().set(KEY, value);
        return "success";
    }

    @GetMapping("value")
    public String getValue() {
        String value = stringRedisTemplate.opsForValue().get(KEY);
        return value == null ? "没有数据" : value;
    }

}
