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
    @NotNull(message = "借书记录id不能为空")
    Integer id;
}

