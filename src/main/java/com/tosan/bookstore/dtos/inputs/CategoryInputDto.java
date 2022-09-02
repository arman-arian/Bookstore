package com.tosan.bookstore.dtos.inputs;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryInputDto extends BaseInputDto {
    private Long id;
    private String name;
}
