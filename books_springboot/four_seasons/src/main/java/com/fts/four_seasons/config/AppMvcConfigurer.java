package com.fts.four_seasons.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fts.four_seasons.annotation.ApiRestController;

@Configuration
public class AppMvcConfigurer implements WebMvcConfigurer {

  /**
   * 前缀/api 注解 @ApiRestController 
   */
  @Override
  public void configurePathMatch(PathMatchConfigurer configurer) {
    configurer.addPathPrefix("/api", c -> c.isAnnotationPresent(ApiRestController.class));
  }

  /**
   * cors enable
   */
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
            .allowCredentials(true)
            .allowedOriginPatterns("*")
            .allowedMethods("*")
            .allowedHeaders("*")
            .exposedHeaders("*");
  }

  /**
   * interceptors
   */
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
      registry.addInterceptor(new TokenInterceptor())
              .addPathPatterns("/**");
  }
}
