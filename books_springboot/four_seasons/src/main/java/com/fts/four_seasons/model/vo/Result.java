package com.fts.four_seasons.model.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class Result<T> implements Serializable {
  private Integer status;
  private String message;
  private T data;

  public Result() {}

  public Result(Integer status, String message, T data) {
    this.status = status;
    this.message = message;
    this.data = data;
  }

  public static <T> Result<T> success(String message, T data) {
    return new Result<T>(0, message, data);
  }

  public static <T> Result<T> error(String message, T data) {
    return new Result<T>(1, message, data);
  }
}
