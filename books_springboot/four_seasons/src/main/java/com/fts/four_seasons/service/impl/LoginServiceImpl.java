package com.fts.four_seasons.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fts.four_seasons.constants.AuthorityConst;
import com.fts.four_seasons.exception.ApiException;
import com.fts.four_seasons.mapper.AuthorityMapper;
import com.fts.four_seasons.mapper.UserMapper;
import com.fts.four_seasons.model.dto.LoginDto;
import com.fts.four_seasons.model.dto.RegisterDto;
import com.fts.four_seasons.model.dto.TokenSubject;
import com.fts.four_seasons.model.entity.Authority;
import com.fts.four_seasons.model.entity.User;
import com.fts.four_seasons.service.LoginService;
import com.fts.four_seasons.util.JwtUtils;

import cn.hutool.core.util.ObjectUtil;

@Service("LoginService")
public class LoginServiceImpl implements LoginService {

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private AuthorityMapper authorityMapper;

  @Override
  public String login(LoginDto dto) {
    User user = (User) userMapper.selectOne(
        new LambdaQueryWrapper<User>()
            .select()
            .eq(User::getAccount, dto.getAccount()));

    if (ObjectUtil.isEmpty(user)) {
      throw new ApiException("用户不存在!");
    }

    Authority authority = authorityMapper.selectById(user.getAuthority());
    String role = ObjectUtil.isNotEmpty(authority) ? authority.getName() : AuthorityConst.NICK.getName();

    TokenSubject subject = TokenSubject.builder()
        .account(user.getAccount())
        .age(user.getAge())
        .cellphone(user.getCellphone())
        .role(role)
        .nickname(user.getNickname())
        .email(user.getEmail())
        .build();

    return JwtUtils.createToken(subject);
  }

  @Override
  public User register(RegisterDto dto) {
    User user = (User) userMapper.selectOne(
        new LambdaQueryWrapper<User>()
            .select()
            .eq(User::getAccount, dto.getAccount()));

    if (ObjectUtil.isNotEmpty(user)) {
      throw new ApiException("账户名已存在!");
    }

    User newUser = User.builder()
        .account(dto.getAccount())
        .nickname(dto.getNickname())
        .age(dto.getAge())
        .cellphone(dto.getCellphone())
        .email(dto.getEmail())
        .pwd(dto.getPassword())
        .authority(AuthorityConst.USER.getId())
        .build();
    int result = userMapper.insert(newUser);
    if (result == 0) {
      throw new ApiException("注册失败");
    }
    return newUser;
  }

}
