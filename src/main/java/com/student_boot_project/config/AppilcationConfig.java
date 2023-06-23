package com.student_boot_project.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**Docket is configation class it helping you to creating end points
 *  and documentation 
 */
@Configuration
@EnableSwagger2
public class AppilcationConfig {

	@Bean
	Docket getDocket() {

		Contact contact = new Contact("pravin", "", "pravin@gmail.com");
		List<VendorExtension> extensions = new ArrayList<>();
		ApiInfo apiInfo = new ApiInfo("student-system",
				"This  is rest API on spring boot ," + 
						"It is used to manage the stdent details", 
						"Apache 1.3.4", "",
						contact, "", "", extensions);
		
		
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.student_boot_project"))
				.build()
				.apiInfo(apiInfo)
				.useDefaultResponseMessages(false);
	}
}
