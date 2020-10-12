package com.bxoon.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ：GuangxiZhong
 * @date ：Created in 2020/10/9 23:31
 * @description：
 * @modified By：
 * @version: 1.0
 */

@FeignClient("sc-provide")
public interface IConsumerFeignClientService {
    @GetMapping("/provider/index")
    String order();

    @GetMapping("/provider/testSeata")
    String testSeata();
}
