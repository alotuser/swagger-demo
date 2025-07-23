package cn.alotus.swaggerdemo.config;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.alotuser.properties.SwaggerProperties;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;

@Configuration
public class SwaggerConfig {

	
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private SwaggerProperties eslProperties;
	
	@Bean
	Docket api() {
		
		Locale locale=eslProperties.getLocale();
		
		String title = messageSource.getMessage("swagger.title", null, locale);
		String description = messageSource.getMessage("swagger.description", null, locale);
		String app=messageSource.getMessage("tag.app", null, locale);
		
		
		
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(new ApiInfoBuilder().title(title).description(description).build())
				.tags(new Tag("app", app))
				.select()
				.apis(RequestHandlerSelectors.basePackage("cn.alotus.swaggerdemo"))
				.paths(PathSelectors.any())
				.build(); 
	}
	
	
	
	
	// UI配置 - 设置默认展开
	@Bean
	 UiConfiguration uiConfig() {
	    return UiConfigurationBuilder.builder().docExpansion(DocExpansion.LIST).build();
	}
	
	
	
	
	


 

	
}
