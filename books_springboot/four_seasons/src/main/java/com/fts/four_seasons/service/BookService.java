package com.fts.four_seasons.service;

import java.util.List;

import com.fts.four_seasons.model.dto.BookDeleteDto;
import com.fts.four_seasons.model.dto.BookUpdateDto;
import com.fts.four_seasons.model.dto.NewBookDto;
import com.fts.four_seasons.model.dto.QueryBookDto;
import com.fts.four_seasons.model.vo.BookVo;
import com.fts.four_seasons.model.vo.TypeVo;

public interface BookService {
  /**
   * 获取图书列表数据
   * @return
   */
  List<BookVo> listBooks(QueryBookDto dto);

  /**
   * 删除图书
   */
  void deleteBook(List<Integer> ids);

  /**
   * 添加图书
   * @param newBook
   */
  void addNewBook(NewBookDto newBook);

  /**
   * 更新图书信息
   * @param updateInfo
   */
  void updateBookInfo(BookUpdateDto updateInfo);

  /**
   * 获取图书列表
   * @return
   */
  List<TypeVo> listTypes();
}
