package com.promptous.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// comment
@Profile({"default", "dev", "test"})
@Configuration
@EnableSwagger2
class SwaggerConfig {

    @Value("${promptous.backend.version}")
    String PROMPTOUS_BACKEND_VERSION;

    @Bean
    public Docket api() {
        Parameter authHeader = new ParameterBuilder()
                .parameterType("header")
                .name("Authorization")
                .modelRef(new ModelRef("string"))
                .build();

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.promptous.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .globalOperationParameters(Collections.singletonList(authHeader));
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "The Promptous API",
                "Promptous Backend",
                PROMPTOUS_BACKEND_VERSION,
                null,
                null,
                null,
                null,
                Collections.emptyList());
    }

}
