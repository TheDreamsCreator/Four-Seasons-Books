package com.fts.four_seasons.model.entity;


import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
//@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date borrowTime;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
//  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date returnTime;
}
