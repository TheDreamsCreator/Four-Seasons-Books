package com.fts.four_seasons.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 自定义api前缀接口注解
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public @interface ApiRestController {
  
  @AliasFor(annotation = RequestMapping.class)
  String name() default "";

  @AliasFor(annotation = RequestMapping.class)
  String[] value() default {};

  @AliasFor(annotation = RequestMapping.class)
  String[] path() default {};
}
