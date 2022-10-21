package com.fts.four_seasons.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.fts.four_seasons.exception.ApiException;
import com.fts.four_seasons.mapper.UserMapper;
import com.fts.four_seasons.model.dto.UserUpdateDto;
import com.fts.four_seasons.model.entity.User;
import com.fts.four_seasons.model.vo.UserVo;
import com.fts.four_seasons.service.UserService;

@Service("UserService")
public class UserServiceImpl implements UserService {

  @Autowired
  private UserMapper userMapper;

  @Override
  public UserVo updateUserInfo(UserUpdateDto dto) {
    User user = userMapper.selectById(dto.getId());
    if (!user.getPwd().equals(dto.getOldPassword())) {
      throw new ApiException("旧密码不正确!");
    }
    int result = userMapper.update(null,
        new LambdaUpdateWrapper<User>()
            .set(User::getAccount, dto.getAccount())
            .set(User::getNickname, dto.getNickname())
            .set(User::getPwd, dto.getNewPassword())
            .eq(User::getAccount, dto.getAccount()));
    if (result == 0) {
      throw new ApiException("用户信息更新失败!");
    }

    return UserVo.builder().account(dto.getAccount()).nickname(dto.getNickname()).build();
  }

}
