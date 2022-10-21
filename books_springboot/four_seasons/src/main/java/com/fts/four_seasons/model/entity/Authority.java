package com.fts.four_seasons.model.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 权限表实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Authority implements Serializable {
  @TableId(type = IdType.AUTO)
  private Integer id;
  private String name;
}
