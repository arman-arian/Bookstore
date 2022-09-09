package com.tosan.bookstore.dtos.inputs;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubCategoryInputDto {
    private Long subCategoryId;
    private String name;
    private Long categoryId;
}
