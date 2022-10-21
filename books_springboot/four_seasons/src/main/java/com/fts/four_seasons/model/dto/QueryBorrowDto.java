package com.fts.four_seasons.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class QueryBorrowDto extends PageDto {
    private Integer id;
    private Integer userId;
    private Integer bookId;
    private Date borrowTime;
    private Date returnTime;
}
