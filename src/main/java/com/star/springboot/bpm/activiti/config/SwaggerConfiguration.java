package com.star.springboot.bpm.activiti.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    private final static String SERVICE_URL = "http://www.github.com";
    private final static String AUTHOR_NAME = "springboot基础项目";

    @Bean
    public UiConfiguration uiConfig() {
        return new UiConfiguration("validatorUrl", // url
                "none", // docExpansion => none | list
                "alpha", // apiSorter => alpha
                "schema", // defaultModelRendering => schema
                true, // enableJsonEditor => true | false
                true); // showRequestHeaders => true | false
    }

    @Bean
    public Docket apiDoc() {
        return createDocket("API接口文档", "对外开放openAPI接口", "/api/.*", "1-API接口").globalOperationParameters(addAccessTokenParameters());
    }


    private Docket createDocket(String title, String description, String path, String groupName) {
        ApiInfo apiInfo = new ApiInfo(title, description, "V1", SERVICE_URL, new Contact(AUTHOR_NAME, "", ""), "", "");

        Set<String> setProtocol = new HashSet<String>();
        setProtocol.add("http");
        setProtocol.add("https");

        Set<String> setProduce = new HashSet<String>();
        setProduce.add("application/json");

        Set<String> setConsume = new HashSet<String>();
        // setConsume.add("x-www-form-urlencoded");

        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.withClassAnnotation(Api.class)).paths(PathSelectors.regex(path)).build().groupName(groupName).pathMapping("/").enable(true).apiInfo(apiInfo).useDefaultResponseMessages(false).protocols(setProtocol).produces(setProduce)
                .consumes(setConsume);
    }

    /**
     * 在header中添加accesstoken
     *
     * @return
     */
    private List<Parameter> addAccessTokenParameters() {
        List<Parameter> listParameter = new ArrayList<Parameter>();
        listParameter.add(new ParameterBuilder().name("accesstoken").description("accesstoken").parameterType("header").required(true).modelRef(new ModelRef("string")).build());
        return listParameter;
    }



}
