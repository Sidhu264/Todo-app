package com.in28minutes.rest.webservices.restfulwebservices;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class RestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(RestfulWebServicesApplication.class);
		Map<String, Object> props = new HashMap<>();
	    String port = System.getenv("PORT");
	    if (port != null) {
	        props.put("server.port", port);
	    }
	    app.setDefaultProperties(props);
	    app.run(args);
	}
	
	//http://localhost:3000/ to 8080
	//Cross Origin Requests
	//Allow all requests only from http://localhost:3000/
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
					.allowedMethods("*")
					.allowedOrigins("*");
			}
		};
	}

}
