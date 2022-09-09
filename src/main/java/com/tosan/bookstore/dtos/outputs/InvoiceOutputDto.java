package com.tosan.bookstore.dtos.outputs;

import com.tosan.bookstore.models.InvoiceState;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InvoiceOutputDto extends BaseOutputDto {
    private Long id;
    private Integer version;
    private LocalDateTime createdDate;
    private String createdBy;
    private LocalDateTime lastModifiedDate;
    private String lastModifiedBy;
    private Boolean deleted = false;
    private LocalDate issuedDate;
    private LocalDate paidDate;
    private BigDecimal totalAmount;
    private InvoiceState state;
    private String description;
}
