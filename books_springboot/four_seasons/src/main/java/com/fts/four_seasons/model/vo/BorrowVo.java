package com.fts.four_seasons.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BorrowVo {
    private Integer id;
    private Integer userId;
    private Integer bookId;
    private Date borrowTime;
    private Date returnTime;
}
