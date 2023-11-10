package com.itheima.pinda.config;


import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 天天进步
 *
 * @Author: ztbox
 * @Date: 2023/11/10/17:32
 * @Description:
 */
@Configuration
@EnableSwagger2
@EnableKnife4j     //开启 knife4j，可以不写
public class Knife4jConfig {

    @Bean(value = "defaultApi3")
    public Docket defaultApi3() {

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                // 定义是否开启swagger，false为关闭，可以通过变量控制
                .enable(true)
                .apiInfo(new ApiInfoBuilder()
                        .title("品达物流pi接口文档")
                        .description("品达物流服务平台Api接口文档")
                        .termsOfServiceUrl("http://localhost:8185")
                        .contact(new Contact("zt", "guangzhou", "ztboxs@163.com"))
                        .version("1.0")
                        .build())
                //分组名称
                .groupName("基础服务服务")
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.itheima.pinda.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
}
