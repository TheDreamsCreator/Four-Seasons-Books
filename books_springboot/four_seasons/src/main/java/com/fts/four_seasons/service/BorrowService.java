package com.fts.four_seasons.service;

import com.fts.four_seasons.model.dto.BookBorrowDto;
import com.fts.four_seasons.model.dto.BookReturnDto;
import com.fts.four_seasons.model.dto.QueryBorrowDto;
import com.fts.four_seasons.model.vo.BorrowVo;

import java.util.List;

public interface BorrowService {


    /**
     * 获取借书记录信息
     * @param dto QueryBorrowDto
     * @return List<BorrowVo>
     */
    List<BorrowVo> listBorrow(QueryBorrowDto dto);
    /**
     * 添加借阅记录
     * @param dto BookBorrowDto
     */
    void addNewBorrow(BookBorrowDto dto);

    /**
     * 归还图书
     * @param dto BookReturnDto
     */
    void returnBook(BookReturnDto dto);
}
