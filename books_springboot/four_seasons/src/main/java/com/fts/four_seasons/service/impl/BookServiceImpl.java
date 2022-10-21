package com.fts.four_seasons.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.fts.four_seasons.exception.ApiException;
import com.fts.four_seasons.mapper.BookMapper;
import com.fts.four_seasons.mapper.TypeMapper;
import com.fts.four_seasons.model.dto.BookUpdateDto;
import com.fts.four_seasons.model.dto.NewBookDto;
import com.fts.four_seasons.model.dto.QueryBookDto;
import com.fts.four_seasons.model.entity.Book;
import com.fts.four_seasons.model.entity.Type;
import com.fts.four_seasons.model.vo.BookVo;
import com.fts.four_seasons.model.vo.TypeVo;
import com.fts.four_seasons.service.BookService;
import com.fts.four_seasons.util.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("BookService")
public class BookServiceImpl implements BookService {

  @Autowired
  private BookMapper bookMapper;

  @Autowired
  private TypeMapper typeMapper;

  @Override
  public List<BookVo> listBooks(QueryBookDto dto) {

    int limit = (dto.getLimit() != null && dto.getLimit() > 0)
        ? dto.getLimit()
        : 0;
    int offset = (dto.getPage() != null && limit != 0 && dto.getPage() > 0)
        ? dto.getLimit() * (dto.getPage() - 1)
        : 0;
    // there would be query all rows if limit and offset equals 0
    List<BookVo> result = bookMapper.listBooks(dto, limit, offset);
    return result;
  }

  @Override
  public void deleteBook(List<Integer> ids) {
    int result = bookMapper.update(null,
        new LambdaUpdateWrapper<Book>()
            .set(Book::getIsDel, 1)
            .in(Book::getId, ids));
    if (result == 0) {
      throw new ApiException("删除图书失败");
    }
  }

  @Override
  public void addNewBook(NewBookDto newBook) {
    Book book = BeanCopyUtils.copyObject(newBook, Book.class);
    int result = bookMapper.insert(book);
    if (result == 0) {
      throw new ApiException("添加图书失败");
    }
  }

  @Override
  public void updateBookInfo(BookUpdateDto updateInfo) {
    Book book = BeanCopyUtils.copyObject(updateInfo, Book.class);
    int result = bookMapper.updateById(book);
    if (result == 0) {
      throw new ApiException("更新图书失败");
    }
  }

  @Override
  public List<TypeVo> listTypes() {
    List<Type> types = typeMapper.selectList(null);
    List<TypeVo> result = BeanCopyUtils.copyList(types, TypeVo.class);
    return result;
  }

}
