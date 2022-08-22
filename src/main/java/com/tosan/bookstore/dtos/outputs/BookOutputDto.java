package com.tosan.bookstore.dtos.outputs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookOutputDto implements Serializable {
    private Long id;

    private String title;

    private String author;

    private String isbn;

    private Long buyPrice;

    private BigDecimal rentRate;

    private String pubName;

    private LocalDate pubDate;

    private Integer pubYear;

    private String description;

    private Boolean isDeleted;

    private LocalDateTime createdOn;

    private String createdBy;

    private LocalDateTime modifiedOn;

    private String modifiedBy;
}
