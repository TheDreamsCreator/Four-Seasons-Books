package com.fts.four_seasons.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fts.four_seasons.annotation.ApiRestController;
import com.fts.four_seasons.model.dto.LoginDto;
import com.fts.four_seasons.model.dto.RegisterDto;
import com.fts.four_seasons.model.vo.Result;
import com.fts.four_seasons.service.LoginService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "授权接口")
@ApiRestController("")
@Validated
public class AuthController {

  @Autowired
  private LoginService loginService;

  @PostMapping("login")
  @ApiOperation(value = "登录")
  public Result<String> login(@RequestBody @Valid LoginDto dto) {
    String token = loginService.login(dto);
    return Result.success("登录成功", token);
  }

  @PostMapping("register")
  @ApiOperation(value = "注册")
  public Result<?> register(@RequestBody RegisterDto dto) {
    loginService.register(dto);
    return Result.success("注册成功", null);
  }
}
