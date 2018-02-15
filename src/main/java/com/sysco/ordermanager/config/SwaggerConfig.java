package com.sysco.ordermanager.config;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spring.web.plugins.DocumentationPluginsManager;
import springfox.documentation.spring.web.scanners.ApiDescriptionReader;
import springfox.documentation.spring.web.scanners.ApiListingScanner;
import springfox.documentation.spring.web.scanners.ApiModelReader;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

/**
 * Created by vibodhab on 2/8/18.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("com.sysco.ordermanager.web.controller"))
                .paths(PathSelectors.regex("/.*"))
                .build()
                .securitySchemes(Lists.newArrayList(apiKey()))
                .apiInfo(apiInfo());

    }


//    @Bean
//    public Docket newsApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build()
//                .securitySchemes(Lists.newArrayList(apiKey()))
//                .apiInfo(apiInfo());
//
//    }

    @Bean
    SecurityConfiguration security() {
        return new SecurityConfiguration(
                "test-app-client-id",
                "test-app-client-secret",
                "test-app-realm",
                "test-app",
                "",
                ApiKeyVehicle.HEADER,
                "Authorization",
                "," /*scope separator*/);
    }

    @Bean
    SecurityScheme apiKey() {
        return new ApiKey("authorization", "authorization", "header");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Order Manager")
                .description("Spring REST Sample with Swagger")
                .version("1.0.0")
                .build();
    }


//    @Primary
//    @Bean
//    public ApiListingScanner addExtraOperations(ApiDescriptionReader apiDescriptionReader, ApiModelReader apiModelReader, DocumentationPluginsManager documentationPluginsManager){
//        return new FormLoginOperations(apiDescriptionReader, apiModelReader, documentationPluginsManager);
//    }





}
