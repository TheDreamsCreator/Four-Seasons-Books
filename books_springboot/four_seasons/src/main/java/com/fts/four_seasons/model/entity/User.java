package com.fts.four_seasons.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户表实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {
  @TableId(type = IdType.AUTO)
  private Integer id;
  private Integer authority;
  private String account;
  private String nickname;
  private String pwd;
  private Integer age;
  private String email;
  private String cellphone;
  private Integer isCancel;
  private Integer borrowId;
}
