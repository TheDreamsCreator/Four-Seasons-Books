package com.fts.four_seasons.model.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RegisterDto {
  @NotBlank(message = "账号不能为空")
  private String account;
  @NotBlank(message = "密码不能为空")
  private String password;
  @NotBlank(message = "昵称不能为空")
  private String nickname;
  @NotBlank(message = "邮箱不能为空")
  private String email;
  @NotBlank(message = "电话不能为空")
  private String cellphone;
  @NotBlank(message = "年龄不能为空")
  private Integer age;
}
