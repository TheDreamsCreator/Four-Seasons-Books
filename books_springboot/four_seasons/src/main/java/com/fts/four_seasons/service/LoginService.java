package com.fts.four_seasons.service;

import com.fts.four_seasons.model.dto.LoginDto;
import com.fts.four_seasons.model.dto.RegisterDto;

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
  void register(RegisterDto dto);
}
