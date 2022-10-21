package com.fts.four_seasons.service;

import com.fts.four_seasons.model.dto.LoginDto;
import com.fts.four_seasons.model.dto.RegisterDto;
import com.fts.four_seasons.model.entity.User;

public interface LoginService {
  /**
   * 登录
   * @param dto
   * @return token
   */
  String login(LoginDto dto);

  /**
   * 注册
   * @param dto
   */
  User register(RegisterDto dto);
}
