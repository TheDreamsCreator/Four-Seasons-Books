package com.fts.four_seasons.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.springframework.web.servlet.HandlerInterceptor;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.fts.four_seasons.constants.AuthorityConst;
import com.fts.four_seasons.exception.ApiException;
import com.fts.four_seasons.model.dto.TokenSubject;
import com.fts.four_seasons.util.JwtUtils;

public class TokenInterceptor implements HandlerInterceptor {
  /**
   * 需要管理员登录
   */
  private static final Set<String> adminUris = new HashSet<String>(
      Arrays.asList("/api/deleteBook", "/api/updateBook", "/api/addBook"));

  /**
   * 需要一般用户登录
   */
  private static final Set<String> userUris = new HashSet<String>(
      Arrays.asList("/api/rentBook", "/api/returnBook"));

  /**
   * token拦截校验
   */
  @Override
  public boolean preHandle(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse res,
      java.lang.Object handler) throws java.lang.Exception {
    String token = req.getHeader("token");
    String uri = req.getRequestURI();
    if (adminUris.contains(uri) || userUris.contains(uri)) {
      if (StringUtils.isEmpty(token)) {
        throw new ApiException("登录已过期, 请重新登录!");
      }
      TokenSubject subject = JwtUtils.parseToken(token);
      String role = subject.getRole();
      // 校验是否有权限访问路由地址
      if (adminUris.contains(uri) && !role.equals(AuthorityConst.ADMIN.getName())) {
        throw new ApiException("需要管理员账户才能进行此操作!");
      }
      if (userUris.contains(uri) && !role.equals(AuthorityConst.USER.getName())) {
        throw new ApiException("登录已过期, 请重新登录!");
      }
    }

    return true;
  }

  @Override
  public void postHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response,
      java.lang.Object handler, org.springframework.web.servlet.ModelAndView modelAndView) throws java.lang.Exception {
  }

  @Override
  public void afterCompletion(javax.servlet.http.HttpServletRequest request,
      javax.servlet.http.HttpServletResponse response, java.lang.Object handler, java.lang.Exception ex)
      throws java.lang.Exception {
  }
}
