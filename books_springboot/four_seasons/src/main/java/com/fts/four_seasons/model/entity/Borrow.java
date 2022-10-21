package com.fts.four_seasons.model.entity;


import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 借阅表实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Borrow implements Serializable {

  @TableId(type = IdType.AUTO)
  private Integer id;

  private Integer userId;

  private Integer bookId;

  private Date borrowTime;

  private Date returnTime;
}
