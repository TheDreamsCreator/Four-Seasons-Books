package com.fts.four_seasons.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class QueryBookDto extends PageDto {
  private String bookname;

  private String author;

  private String publisher;

  private Integer isBorrow;
}
