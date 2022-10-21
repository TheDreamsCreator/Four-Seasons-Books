package com.fts.four_seasons.config;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fts.four_seasons.exception.ApiException;
import com.fts.four_seasons.model.vo.Result;

@RestControllerAdvice
public class GlobalExceptionHanlder {

  /**
   * 自定义api异常
   * 
   * @param request
   * @param e
   * @return
   */
  @ExceptionHandler(value = ApiException.class)
  @ResponseBody
  public Result<?> apiExceptionHandler(HttpServletRequest request, ApiException e) {
    return Result.error(e.getMessage(), null);
  }

  /**
   * 接收参数异常
   * 
   * @param e
   * @return
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseBody
  public Result<?> bindException(MethodArgumentNotValidException e) {
    BindingResult bindingResult = e.getBindingResult();
    return Result.error(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage(), null);
  }
}
