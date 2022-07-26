package com.tosan.bookstore.dtos.inputs;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryInputDto extends BaseInputDto {
    private Long categoryId;
    private String name;
}
