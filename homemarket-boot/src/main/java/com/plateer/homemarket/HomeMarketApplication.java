package com.plateer.homemarket;

import java.util.Collections;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.RestController;

import lombok.val;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class HomeMarketApplication {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(HomeMarketApplication.class, args);
	}
	
//	@Bean
//	public Docket docket() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.forCodeGeneration(true)
//				.globalOperationParameters(globalParameterList())
//				.select()
//				.apis( RequestHandlerSelectors.withClassAnnotation(RestController.class))
//				.paths(PathSelectors.any())
//				.build();
//	}
//
//	private List<Parameter> globalParameterList() {
//
//		val authTokenHeader =
//				new ParameterBuilder()
//						.name("AUTH-TOKEN") // name of the header
//						.modelRef(new ModelRef("string")) // data-type of the header
//						.required(true) // required/optional
//						.parameterType("header") // for query-param, this value can be 'query'
//						.description("auth token")st6
//						.build();
//
//		return Collections.singletonList(authTokenHeader);
//	}

}
