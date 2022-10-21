package com.fts.four_seasons.service.impl;

import com.fts.four_seasons.exception.ApiException;
import com.fts.four_seasons.mapper.BorrowMapper;
import com.fts.four_seasons.model.dto.BookBorrowDto;
import com.fts.four_seasons.model.dto.BookReturnDto;
import com.fts.four_seasons.model.dto.QueryBorrowDto;
import com.fts.four_seasons.model.entity.Book;
import com.fts.four_seasons.model.entity.Borrow;
import com.fts.four_seasons.model.vo.BookVo;
import com.fts.four_seasons.model.vo.BorrowVo;
import com.fts.four_seasons.service.BorrowService;
import com.fts.four_seasons.util.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("BorrowService")
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    private BorrowMapper borrowMapper;

    @Override
    public List<BorrowVo> listBorrow(QueryBorrowDto dto) {
        int limit = (dto.getLimit() != null && dto.getLimit() > 0)
                ? dto.getLimit()
                : 0;
        int offset = (dto.getPage() != null && limit != 0 && dto.getPage() > 0)
                ? dto.getLimit() * (dto.getPage() - 1)
                : 0;
        //如果limit和offset等于0，则查询所有行
        return borrowMapper.listBorrow(dto, limit, offset);
    }

    @Override
    public void addNewBorrow(BookBorrowDto bookBorrowDto) {
        Borrow borrow = BeanCopyUtils.copyObject(bookBorrowDto, Borrow.class);
        int result = borrowMapper.insert(borrow);
        if (result == 0) {
            throw new ApiException("添加借书记录失败");
        }
    }

    @Override
    public void returnBook(BookReturnDto bookReturnDto) {
        Borrow borrow = BeanCopyUtils.copyObject(bookReturnDto, Borrow.class);
        int result = borrowMapper.updateById(borrow);
        if (result == 0) {
            throw new ApiException("更新借书记录失败");
        }
    }
}
