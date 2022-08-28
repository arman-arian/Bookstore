package com.tosan.bookstore.dtos.inputs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

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
    private LocalDate pubDate;
    private Integer pubYear;
    private String summary;
    private String imageUrl;
    private String fileUrl;
    private Long subCategoryId;
}
