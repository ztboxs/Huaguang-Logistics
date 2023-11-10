package com.itheima.pinda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 天天进步
 *
 * @Author: ztbox
 * @Date: 2023/11/10/15:56
 * @Description: 基础服务启动类
 */

@SpringBootApplication
@EnableDiscoveryClient
public class BaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class, args);
    }

}
