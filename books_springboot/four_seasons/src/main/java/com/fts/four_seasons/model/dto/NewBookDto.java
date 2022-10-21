package com.fts.four_seasons.model.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewBookDto {
  @NotBlank(message = "图书名称不能为空")
  private String bookname;
  @NotBlank(message = "作者不能为空")
  private String author;
  @NotBlank(message = "出版社不能为空")
  private String publisher;
  private Integer type;
  private Integer isBorrow;
  private Integer isDel;
}
