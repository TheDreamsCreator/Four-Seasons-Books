package com.fts.four_seasons.model.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 图书表实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book implements Serializable {
  @TableId(type = IdType.AUTO)
  private Integer id;
  @TableField(value = "name")
  private String bookname;
  private String author;
  private String publisher;
  private String isbn;
  private Integer type;
  private String description;
  private Integer isBorrow;
  private Integer isDel;
  private Integer borrowId;
}
