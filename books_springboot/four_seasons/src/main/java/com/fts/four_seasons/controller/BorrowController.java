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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Api(tags = "借书、还书接口")
@ApiRestController("")
@Validated
public class BorrowController {

    @Autowired()
    private BorrowService borrowService;

    @GetMapping("getBorrowList")
    @ApiOperation(value = "分页条件查询借书记录列表")
    public Result<List<BorrowVo>> borrowList(QueryBorrowDto dto) {
        System.out.println(dto.getUserId());
        List<BorrowVo> data = borrowService.listBorrow(dto);
        return Result.success("获取借书记录成功!", data);
    }

    @PostMapping("borrowBook")
    @ApiOperation(value = "用户进行借书操作，增加借书记录")
    public Result<List<BorrowVo>> borrowBook(@RequestBody BookBorrowDto dto) {
        borrowService.addNewBorrow(dto);
        return Result.success("借书成功!", null);
    }

    @PutMapping("updateBorrow")
    @ApiOperation(value = "归还图书，更新借书记录归还日期")
    public Result<List<BorrowVo>> returnBook(@RequestBody BookReturnDto dto) {
        borrowService.returnBook(dto);
        return Result.success("归还成功!", null);
    }

}
