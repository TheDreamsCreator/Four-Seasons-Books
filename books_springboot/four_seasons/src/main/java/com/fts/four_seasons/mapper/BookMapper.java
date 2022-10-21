package com.fts.four_seasons.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fts.four_seasons.model.dto.QueryBookDto;
import com.fts.four_seasons.model.entity.Book;
import com.fts.four_seasons.model.vo.BookVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMapper extends BaseMapper<Book> {
    /**
     * 分页查询
     *
     * @param dto QueryBookDto
     * @return List<BookVo>
     */
    List<BookVo> listBooks(@Param("condition") QueryBookDto dto, @Param("limit") Integer limit,
                           @Param("offset") Integer offset);
}
