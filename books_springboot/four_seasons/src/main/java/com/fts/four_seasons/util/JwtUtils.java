package com.fts.four_seasons.util;

import java.util.Calendar;
import java.util.Date;

import com.fts.four_seasons.model.dto.TokenSubject;

import cn.hutool.jwt.JWT;
/**
 * Jwt 
 */
public class JwtUtils {
  /**
   * key
   */
  private static final String key = "fourseasons";

  /**
   * expire: 7d
   */
  private static final Integer expire = 7;

  /**
   * 生成token
   * @param subject 
   * @return
   */
  public static String createToken(TokenSubject subject) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date());
    calendar.add(Calendar.DATE, expire);
    Date expireDate = calendar.getTime();

    String token = JWT.create()
        .setPayload("id", subject.getId())
        .setPayload("account", subject.getAccount())
        .setPayload("role", subject.getRole())
        .setPayload("age", subject.getAge())
        .setPayload("cellphone", subject.getCellphone())
        .setPayload("email", subject.getEmail())
        .setPayload("nickname", subject.getNickname())
        .setExpiresAt(expireDate)
        .setKey(key.getBytes())
        .sign();
    return token;
  }

  /**
   * 解析token
   * @param token
   * @return
   */
  public static TokenSubject parseToken(String token) {
    JWT jwt = JWT.of(token);
    Integer id = (Integer) jwt.getPayload("id");
    String account = (String) jwt.getPayload("account");
    String role = (String) jwt.getPayload("role");
    Integer age = (Integer) jwt.getPayload("age");
    String cellphone = (String) jwt.getPayload("cellphone");
    String email = (String) jwt.getPayload("email");
    String nickname = (String) jwt.getPayload("nickname");
    return TokenSubject.builder()
        .id(id)
        .account(account)
        .role(role)
        .age(age)
        .cellphone(cellphone)
        .email(email)
        .nickname(nickname)
        .build();
  }
}
