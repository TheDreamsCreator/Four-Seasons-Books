package com.fts.four_seasons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fts.four_seasons.annotation.ApiRestController;
import com.fts.four_seasons.model.dto.UserUpdateDto;
import com.fts.four_seasons.model.vo.Result;
import com.fts.four_seasons.model.vo.UserVo;
import com.fts.four_seasons.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;

@Api(tags = "用户接口")
@ApiRestController("")
@Validated
public class UserController {

  @Autowired
  private UserService userService;

  @PutMapping("userInfo")
  @ApiOperation(value = "修改用户信息")
  public Result<UserVo> updateUserInfo(@Valid @RequestBody UserUpdateDto dto) {
    UserVo updatedInfo = userService.updateUserInfo(dto);
    return Result.success("用户信息更新成功", updatedInfo);
  }
}
