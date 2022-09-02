package com.tosan.bookstore.dtos.outputs;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubCategoryOutputDto  extends BaseOutputDto  {
    private Long id;
    private String name;
}
