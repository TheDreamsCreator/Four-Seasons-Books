package com.fts.four_seasons.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
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
  @Min(value = 7, message = "请输入7位以上的账号")
  private String account;

  @NotBlank(message = "密码不能为空")
  @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,24}$", message = "密码必须由大小写字母和数字组成, 且长度在6到24之间")
  private String password;

  @NotBlank(message = "请输入昵称")
  private String nickname;

  @NotBlank(message = "邮箱不能为空")
  @Email(message = "请输入正确的邮箱格式")
  private String email;

  @NotBlank(message = "电话不能为空")
  @Length(min = 11, max = 11, message = "请输入正确格式的手机号")
  private String cellphone;

  @NotNull(message = "请输入年龄")
  private Integer age;
}
