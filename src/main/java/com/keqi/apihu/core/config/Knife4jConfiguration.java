package com.keqi.apihu.core.config;

import com.keqi.apihu.core.common.AjaxEntityBuilder;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2WebMvc
@AllArgsConstructor
public class Knife4jConfiguration {

    @Bean
    public Docket sys() {
        return new Docket(DocumentationType.SWAGGER_2)
                .globalResponseMessage(RequestMethod.GET, responseMessageList())
                .globalResponseMessage(RequestMethod.POST, responseMessageList())
                .globalResponseMessage(RequestMethod.PUT, responseMessageList())
                .globalResponseMessage(RequestMethod.DELETE, responseMessageList())
                .useDefaultResponseMessages(false)
                .groupName("一、系统管理模块")
                .apiInfo(systemMangerInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.keqi.apihu.manage"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket pj() {
        return new Docket(DocumentationType.SWAGGER_2)
                .globalResponseMessage(RequestMethod.GET, responseMessageList())
                .globalResponseMessage(RequestMethod.POST, responseMessageList())
                .globalResponseMessage(RequestMethod.PUT, responseMessageList())
                .globalResponseMessage(RequestMethod.DELETE, responseMessageList())
                .useDefaultResponseMessages(false)
                .groupName("二、API 管理模块")
                .apiInfo(systemMangerInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.keqi.apihu.pj"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo systemMangerInfo() {
        return new ApiInfoBuilder()
                .title("API-HU")
                .description("API-HU 接口文档管理工具")
                .termsOfServiceUrl("http://localhost:9091/api-hu")
                .version("1.0")
                .build();
    }

    private List<ResponseMessage> responseMessageList() {
        List<ResponseMessage> list = new ArrayList<>();

        list.add(new ResponseMessageBuilder()
                .code(AjaxEntityBuilder.successCode)
                .message(AjaxEntityBuilder.successMsg)
                .responseModel(new ModelRef("Json")).build());

        list.add(new ResponseMessageBuilder()
                .code(AjaxEntityBuilder.failureCode)
                .message(AjaxEntityBuilder.failureMsg)
                .responseModel(new ModelRef("Json")).build());

        list.add(new ResponseMessageBuilder()
                .code(AjaxEntityBuilder.noAuthCode)
                .message(AjaxEntityBuilder.noAuthMsg)
                .responseModel(new ModelRef("Json")).build());

        return list;
    }
}
