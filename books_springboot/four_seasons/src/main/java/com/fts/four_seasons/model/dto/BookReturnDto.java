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
public class BookReturnDto {
    @NotNull(message = "借书id不能为空")
    private Integer id;
    @NotNull(message = "图书id不能为空")
    private Integer book_id;
}

