package com.itheima.pinda.common;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.itheima.pinda.common.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 天天进步
 *
 * @Author: ztbox
 * @Date: 2023/11/10/18:00
 * @Description: 自定义ID生成器
 */
@Component
public class CustomIdGenerator implements IdentifierGenerator {

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1, 1);
    }

    @Autowired
    private IdWorker idWorker;

    @Override
    public Long nextId(Object entity) {
        return idWorker.nextId();
    }
}
