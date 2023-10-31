package com.ingsoftware.modalidadesapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ModalidadesappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModalidadesappApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer webMvcConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addResourceHandlers(ResourceHandlerRegistry registry) {
				registry.addResourceHandler("/pdfs/**")
						.addResourceLocations("C:/AppServ/www/modalidadesapp/src/main/resources/adjuntos/");
			}
		};
	}
}
