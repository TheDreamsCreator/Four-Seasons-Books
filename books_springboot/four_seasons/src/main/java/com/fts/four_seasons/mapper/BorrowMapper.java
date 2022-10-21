package com.fts.four_seasons.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fts.four_seasons.model.entity.Borrow;

@Mapper
public interface BorrowMapper extends BaseMapper<Borrow> {
  
}
