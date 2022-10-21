package com.fts.four_seasons.model.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserUpdateDto {
  @NotBlank(message = "用户id不能为空")
  private Integer id;
  @NotBlank(message = "昵称不能为空")
  private String nickname;
  @NotBlank(message = "账号不能为空")
  private String account;
  @NotBlank(message = "旧密码不能为空")
  private String oldPassword;
  @NotBlank(message = "新密码不能为空")
  private String newPassword;
}
