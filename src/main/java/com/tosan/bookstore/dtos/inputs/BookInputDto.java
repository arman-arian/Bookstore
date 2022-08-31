package com.tosan.bookstore.dtos.inputs;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookInputDto implements Serializable {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private BigDecimal buyPrice;
    private BigDecimal rentPrice;
    private String pubName;
    private Integer pubYear;
    private String summary;
    private Long subCategoryId;
}
