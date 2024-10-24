package org.hl.springlearn.aopdemo.controller;

import org.hl.springlearn.aopdemo.annotation.WebLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author houlei
 */
@RestController
public class AopController {
    @GetMapping("/hello")
    @WebLog(desc = "这是一个欢迎接口")
    public String hello(String name) {
        return "Hello " + name;
    }

}
