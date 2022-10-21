package com.fts.four_seasons.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fts.four_seasons.model.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
  
}
