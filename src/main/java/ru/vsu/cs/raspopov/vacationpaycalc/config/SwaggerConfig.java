package ru.vsu.cs.raspopov.vacationpaycalc.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RequiredArgsConstructor
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    private final BuildProperties buildProperties;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.regex("/calculate"))
                .build()
                .apiInfo(apiDetail());
    }

    private ApiInfo apiDetail() {
        return new ApiInfo(
                "Vacation calc API",
                "FULL API documentation here",
                buildProperties.getVersion(),
                "Full free to use",
                "tukitoki",
                "API license",
                "url"
        );
    }
}
