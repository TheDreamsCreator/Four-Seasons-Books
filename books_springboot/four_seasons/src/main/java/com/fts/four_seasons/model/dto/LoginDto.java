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
public class LoginDto {
  @NotBlank(message = "账号不能为空")
  private String account;
  @NotBlank(message = "密码不能为空")
  private String password;
}
