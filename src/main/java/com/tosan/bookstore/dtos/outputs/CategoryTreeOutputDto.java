package com.tosan.bookstore.dtos.outputs;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryTreeOutputDto implements Serializable {
    private Long Id;
    private String Name;
    private Boolean IsRoot;
}
