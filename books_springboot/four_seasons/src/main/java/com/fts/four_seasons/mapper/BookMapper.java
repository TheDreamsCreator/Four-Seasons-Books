package com.fts.four_seasons.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fts.four_seasons.model.dto.QueryBookDto;
import com.fts.four_seasons.model.entity.Book;
import com.fts.four_seasons.model.vo.BookVo;;

@Mapper
public interface BookMapper extends BaseMapper<Book> {
  /**
   * 分页查询
   * @param condition
   * @return
   */
  List<BookVo> listBooks(@Param("condition") QueryBookDto dto, @Param("limit") Integer limit,
      @Param("offset") Integer offset);
}
