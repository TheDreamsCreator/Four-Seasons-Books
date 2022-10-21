package com.fts.four_seasons.service.impl;

import com.fts.four_seasons.exception.ApiException;
import com.fts.four_seasons.mapper.BorrowMapper;
import com.fts.four_seasons.model.dto.BookBorrowDto;
import com.fts.four_seasons.model.dto.BookReturnDto;
import com.fts.four_seasons.model.dto.QueryBorrowDto;
import com.fts.four_seasons.model.entity.Borrow;
import com.fts.four_seasons.model.vo.BorrowVo;
import com.fts.four_seasons.service.BorrowService;
import com.fts.four_seasons.util.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
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
    //声明事务
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addNewBorrow(BookBorrowDto dto) {
        Borrow borrow = BeanCopyUtils.copyObject(dto, Borrow.class);
        //获取当前系统时间
        Date date = new Date();
        //转换为数据库datetime格式
        Timestamp timestamp = new Timestamp(date.getTime());
        borrow.setBorrowTime(timestamp);
        borrowMapper.insert(borrow);
    }

    //声明事务
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void returnBook(BookReturnDto bookReturnDto) {
        Borrow borrow = BeanCopyUtils.copyObject(bookReturnDto, Borrow.class);
        //获取当前系统时间
        Date date = new Date();
        //转换为数据库datetime格式
        Timestamp timestamp = new Timestamp(date.getTime());
        borrow.setReturnTime(timestamp);
        int result = borrowMapper.updateById(borrow);
        if (result == 0) {
            throw new ApiException("更新借书记录失败");
        }
    }
}
