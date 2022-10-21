package com.fts.four_seasons.service;

import com.fts.four_seasons.model.dto.UserUpdateDto;
import com.fts.four_seasons.model.vo.UserVo;

public interface UserService {

  /**
   * 用户修改个人信息
   * 
   * @param dto
   * @return
   */
  UserVo updateUserInfo(UserUpdateDto dto);
}
