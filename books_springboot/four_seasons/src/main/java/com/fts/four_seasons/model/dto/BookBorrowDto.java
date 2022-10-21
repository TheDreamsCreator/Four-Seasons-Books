package com.fts.four_seasons.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookBorrowDto {
    @NotNull(message = "借书记录id不能为空")
    private Integer id;
    @NotNull(message = "借书用户不能为空")
    private Integer userId;
    @NotNull(message = "所借图书id不能为空")
    private Integer bookId;
}
