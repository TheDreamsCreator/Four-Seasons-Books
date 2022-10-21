package com.fts.four_seasons.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fts.four_seasons.service.BookService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.fts.four_seasons.annotation.ApiRestController;
import com.fts.four_seasons.model.dto.BookDeleteDto;
import com.fts.four_seasons.model.dto.BookUpdateDto;
import com.fts.four_seasons.model.dto.NewBookDto;
import com.fts.four_seasons.model.dto.QueryBookDto;
import com.fts.four_seasons.model.vo.BookVo;
import com.fts.four_seasons.model.vo.Result;
import com.fts.four_seasons.model.vo.TypeVo;

@Api(tags = "图书接口")
@ApiRestController("")
@Validated
public class BookController {

  @Autowired()
  private BookService bookService;

  @GetMapping("getBookList")
  @ApiOperation(value = "分页条件查询图书列表")
  public Result<List<BookVo>> booklist(QueryBookDto dto) {
    List<BookVo> data = bookService.listBooks(dto);
    return Result.success("获取图书列表成功!", data);
  }

  @PutMapping("deleteBook")
  @ApiOperation(value = "删除图书")
  public Result<?> deleteBook(@RequestBody List<Integer> ids) {
    bookService.deleteBook(ids);
    return Result.success("删除图书成功", null);
  }

  @PostMapping("addBook")
  @ApiOperation(value = "添加图书")
  public Result<?> addBook(@RequestBody @Valid NewBookDto newBook) {
    bookService.addNewBook(newBook);
    return Result.success("添加图书成功", null);
  }

  @PostMapping("updateBook")
  @ApiOperation(value = "更新图书信息")
  public Result<?> updateBook(@RequestBody @Valid BookUpdateDto updateInfo) {
    bookService.updateBookInfo(updateInfo);
    return Result.success("更新图书成功", null);
  }

  @GetMapping("getBookTypes")
  @ApiOperation(value = "图书类型列表")
  public Result<List<TypeVo>> bookTypeList() {
    List<TypeVo> types = bookService.listTypes();
    return Result.success("获取图书类型列表成功", types);
  }

}
