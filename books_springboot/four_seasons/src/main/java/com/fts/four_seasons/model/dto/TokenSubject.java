package com.fts.four_seasons.model.dto;

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
public class TokenSubject {
  private Integer id;
  private String nickname;
  private String account;
  private String role;
  private String email;
  private Integer age;
  private String cellphone;
}
