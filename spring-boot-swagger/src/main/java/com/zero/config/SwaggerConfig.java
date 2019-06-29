package com.zero.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ：Zero
 * @date ：Created in 2019/6/28 18:07
 * @modified By：
 */
@Configuration
@EnableSwagger2   //  表示此项目启用SwaggerAPI文档
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //  自行车修改为自己的包路径
                .apis(RequestHandlerSelectors.basePackage("com.zero.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("客户端管理")
                .description("客户化管理中心 API 1.0 操作文档")
                //  服务条款网址
                .termsOfServiceUrl("http://www.ityouknow.com/")
                .version("1.0")
                .contact(new Contact("Zero","http://www.ityouknow.com/", "ityouknow@126.com"))
                .build();
    }

}
