package com.example.demo_project.config;

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

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public static final ApiInfo DEFAULT_API_INFO = new ApiInfoBuilder()
			.title("RESTful APIs")
//			.description("RESTful APIs")
//			.termsOfServiceUrl("urn:tos")
//			.contact(new Contact("DEFAULT","",""))
//			.license("Apache 2.0")
//			.version("v3")
//			.licenseUrl("https://www.apache.org/licenses/LICENSES-2.0.txt")
			.build();
	
			
			
			
			
			
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT_API_INFO) //���API�򥻸�T �i���[
				.select()  //�^�Ǥ@�� ApiSelectBuilder ��ҡA�Ψӱ���Ǥ����i�H��Swagger�Ӯi�{
				//�]�w�M�󱽴y���|
				//Swagger �|���y�M��U�Ҧ�Controller�w�q��API �ò��ͤ��
				//�Y���QAPI���ͬ������A�i�bAPI�W�[�W @ApiIgnore
				.apis(RequestHandlerSelectors.basePackage("com.example.demo_project.controller"))
				.paths(PathSelectors.any())
				.build();
		
	}
}
