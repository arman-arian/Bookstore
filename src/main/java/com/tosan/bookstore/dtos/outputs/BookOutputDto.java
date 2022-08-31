package com.tosan.bookstore.dtos.outputs;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookOutputDto implements Serializable {
    private Long id;
    private Integer version;
    private LocalDateTime createdDate;
    private String createdBy;
    private LocalDateTime lastModifiedDate;
    private String lastModifiedBy;
    private Boolean deleted = false;
    private String title;
    private String author;
    private String isbn;
    private BigDecimal buyPrice;
    private BigDecimal rentPrice;
    private String pubName;
    private Integer pubYear;
    private String summary;
}
