package com.example.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class QuotesConfig implements WebMvcConfigurer {
	   @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/api/quotes/addQuote")  // Adjust the mapping as per your API endpoints
	                .allowedOrigins("*")  // Allow requests from all origins, you can restrict it to specific origins if needed
	                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Allow these HTTP methods
	                .allowedHeaders("Content-Type", "Authorization");  // Allow these headers
	        registry.addMapping("/api/quotes/getQuotes")  // Adjust the mapping as per your API endpoints
            .allowedOrigins("*")  // Allow requests from all origins, you can restrict it to specific origins if needed
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Allow these HTTP methods
            .allowedHeaders("Content-Type", "Authorization");  // Allow these headers
	    }
}