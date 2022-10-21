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
    private Integer bookId;
    private String bookName;
    private String bookIsbn;
    private String bookAuthor;
    private String bookPublisher;
    private String typeName;
    private Date borrowTime;
}
