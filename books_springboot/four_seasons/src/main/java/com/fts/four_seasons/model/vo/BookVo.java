package com.fts.four_seasons.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookVo {
  private Integer id;
  private String bookname;
  private String author;
  private String publisher;
  private String isbn;
  private String typeId;
  private String type;
  private Integer isDel;
}