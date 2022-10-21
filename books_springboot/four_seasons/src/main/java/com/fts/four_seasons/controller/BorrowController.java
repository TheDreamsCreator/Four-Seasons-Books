package com.fts.four_seasons.controller;

import com.fts.four_seasons.annotation.ApiRestController;
import com.fts.four_seasons.model.dto.BookBorrowDto;
import com.fts.four_seasons.model.dto.BookReturnDto;
import com.fts.four_seasons.model.dto.QueryBorrowDto;
import com.fts.four_seasons.model.vo.BorrowVo;
import com.fts.four_seasons.model.vo.Result;
import com.fts.four_seasons.service.BorrowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Api(tags = "借书、还书接口")
@ApiRestController("")
@Validated
public class BorrowController {

    @Autowired()
    private BorrowService BorrowService;

    @GetMapping("getBorrowList")
    @ApiOperation(value = "分页条件查询借书记录列表")
    public Result<List<BorrowVo>> borrowList(QueryBorrowDto dto) {
        List<BorrowVo> data = BorrowService.listBorrow(dto);
        return Result.success("获取借书记录成功!", data);
    }

    @GetMapping("borrowBook")
    @ApiOperation(value = "用户进行借书操作，增加借书记录")
    public Result<List<BorrowVo>> borrowBook(BookBorrowDto dto) {
        BorrowService.addNewBorrow(dto);
        return Result.success("借书成功!", null);
    }

    @GetMapping("updateBorrow")
    @ApiOperation(value = "归还图书，更新借书记录归还日期")
    public Result<List<BorrowVo>> returnBook(BookReturnDto dto) {
        BorrowService.returnBook(dto);
        return Result.success("归还成功!", null);
    }

}
