package com.sachishin.comprente.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis (RequestHandlerSelectors.basePackage ("com.example.demo.controller")) // Пакет сканирования Swagger
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //Заголовок страницы
                .title ("Spring Boot в сочетании с Swagger2 для создания RESTful API")
                // основатель
                .contact(new Contact("Licf", "http://www.loveyoursmile.top", "canfengli@126.com"))
                //Описание
                .description ("Простой и элегантный стиль Restful, адрес блога: http://blog.csdn.net/canfengli")
                .termsOfServiceUrl("http://blog.csdn.net/canfengli")
                //номер версии
                .version("1.0")
                .build();
    }

}
