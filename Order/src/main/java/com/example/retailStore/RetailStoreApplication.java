package com.example.retailStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
//@EnableAutoConfiguration
//@EnableWebMvc
//@CrossOrigin("*")
//@ComponentScan("com.example.retailStore")
public class RetailStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailStoreApplication.class, args);
	}

//	@Bean
//	public WebMvcConfigurer corsConfigure(){
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**").allowedMethods("GET","POST","PUT","DELETE").allowedOrigins("*")
//						.allowedHeaders("*");
//			}
//		};
//	}

}
