
  package com.onlineexam.demo.config;
  
  import org.springframework.context.annotation.Configuration; 

  import org.springframework.web.servlet.config.annotation.CorsRegistry; 
  import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.GzipResourceResolver;
import org.springframework.web.servlet.resource.PathResourceResolver;
 


  @Configuration
  public class CORSConfig implements WebMvcConfigurer {
  
  @Override 
  public void addCorsMappings(CorsRegistry registry) {
  registry.addMapping("/**"); /*.allowedMethods("HEAD", "GET", "PUT", "POST",
  "DELETE", "PATCH");*/ } 
  
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
	  registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
  }
  
  }
 