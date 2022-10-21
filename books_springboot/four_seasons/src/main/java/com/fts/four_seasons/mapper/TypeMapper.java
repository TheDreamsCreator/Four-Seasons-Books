package com.fts.four_seasons.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fts.four_seasons.model.entity.Type;

@Mapper
public interface TypeMapper extends BaseMapper<Type> {
  
}
