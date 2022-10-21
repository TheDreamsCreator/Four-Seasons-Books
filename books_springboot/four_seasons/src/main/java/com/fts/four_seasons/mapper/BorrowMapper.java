package com.fts.four_seasons.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fts.four_seasons.model.dto.QueryBorrowDto;
import com.fts.four_seasons.model.entity.Borrow;
import com.fts.four_seasons.model.vo.BorrowVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BorrowMapper extends BaseMapper<Borrow> {

    /**
     *
     * @param dto QueryBorrowDto
     * @param limit Integer
     * @param offset Integer
     * @return List<BorrowVo>
     */
    List<BorrowVo> listBorrow(@Param("condition") QueryBorrowDto dto, @Param("limit") Integer limit,
                                 @Param("offset") Integer offset);
}
