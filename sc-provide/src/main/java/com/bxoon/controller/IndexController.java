package com.bxoon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：GuangxiZhong
 * @date ：Created in 2020/10/9 21:27
 * @description：
 * @modified By：
 * @version: 1.0
 */

@RestController
@RequestMapping("/provider")
public class IndexController {

    @GetMapping("/index")
    public String index() {
        return "8002";
    }

    @GetMapping("/testSeata")
    public String testSeata(){
        throw new RuntimeException("testSeata Exception");
    }
}
