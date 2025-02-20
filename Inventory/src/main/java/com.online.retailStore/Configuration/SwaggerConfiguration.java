package com.online.retailStore.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    private static final String TITLE="ONLINE RETAIL STORE";
    private static final String DESCRIPTION="API Documentation";

    /**
     * Providing app information to swagger
     * @return ApiInfo
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title(TITLE)
                .description(DESCRIPTION)
                .build();
    }

    @Bean
    public Docket productApi(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.online.retailStore"))
                .paths(PathSelectors.any())
                .build();
    }
}
