package com.xh.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * JpaController
 *
 * @author xiaohe
 */
@RestController
@RequestMapping("jpa")
public class JpaController {

    public JdbcTemplate jdbcTemplate;

    public JpaController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("list")
    public List<Map<String, Object>> list() {
        return this.jdbcTemplate.queryForList("SELECT id,name FROM test");
    }

    @DeleteMapping("del/{id}")
    public String del(@PathVariable(value = "id") Long id) {
        if (id == null || id < 0) {
            return "fail";
        }
        int affectRowNum = this.jdbcTemplate.update("DELETE FROM test WHERE id = ?", id);
        return affectRowNum > 0 ? "success" : "fail";
    }

    @PostMapping("save")
    public String update(String name) {
        if (StringUtils.isEmpty(StringUtils.trimWhitespace(name))) {
            return "入参不能为空";
        }
        int affectRowNum = this.jdbcTemplate.update("INSERT INTO test(name) VALUES (?)", name);
        return affectRowNum > 0 ? "success" : "fail";
    }

}
