package com.fts.four_seasons.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 权限enum
 */
@Getter
@AllArgsConstructor
public enum AuthorityConst {

  NICK(1, "游客"),
  USER(2, "一般用户"),
  ADMIN(3, "管理员");
  

  private Integer id;
  private String name;


}
