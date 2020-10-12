package com.bxoon.controller;

import com.bxoon.service.IConsumerFeignClientService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：GuangxiZhong
 * @date ：Created in 2020/10/9 23:30
 * @description：
 * @modified By：
 * @version: 1.0
 */
@RestController
@RequestMapping("/consumer")
@RefreshScope
public class IndexController {
    @Autowired
    private IConsumerFeignClientService feignClientService;
    private final JdbcTemplate jdbcTemplate;

    public IndexController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     *
     * 测试OpenFeign
     * @return
     */
    @GetMapping("/index")
    public String index(){
        return feignClientService.order();
    }

    @Value("${user.name}")
    private String name;

    /**
     *
     * 测试Nacos配置中心
     * @return
     */
    @GetMapping("/testNacosProperty")
    public String testNacosProperty(){
        return name;
    }

    /**
     * 测试Seata
     * @return
     */
    @GetMapping("/testSeata")
    @GlobalTransactional(timeoutMills = 300000, name = "sc-demo-tx")
    public String testSeata(){
        int result = jdbcTemplate.update(
                "update storage_tbl set count = count - ? where commodity_code = ?",
                new Object[] { 1, "C00321" });
        feignClientService.testSeata();

        return "successs";
    }

}
