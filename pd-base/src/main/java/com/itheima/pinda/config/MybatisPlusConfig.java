package com.itheima.pinda.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 天天进步
 *
 * @Author: ztbox
 * @Date: 2023/11/10/18:05
 * @Description: MybatisPlus配置
 */
@Configuration
public class MybatisPlusConfig {
    /**
     * MybatisPlus分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
