package com.sachishin.comprente.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("My service Web Api documentation")
                                .version("1.3.3.7")
                                .contact(
                                        new Contact()
                                                .email("stackoverflow@mail.com")
                                                .url("https://github.com/IoannJohansen")
                                                .name("Ivan Sachishin")
                                )
                );
    }
}
