package com.fts.four_seasons.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookUpdateDto {
  @NotNull(message = "图书id不能为空")
  private Integer id;
  @NotBlank(message = "图书名称不能为空")
  private String bookname;
  @NotBlank(message = "作者不能为空")
  private String author;
  @NotBlank(message = "出版社不能为空")
  private String publisher;
  @NotBlank(message = "isbn不能为空")
  private String isbn;
  private Integer type;
  private Integer isBorrow;
  private Integer isDel;
}
