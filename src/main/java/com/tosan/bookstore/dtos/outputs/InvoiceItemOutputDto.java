package com.tosan.bookstore.dtos.outputs;

import com.tosan.bookstore.models.PaymentType;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InvoiceItemOutputDto extends BaseOutputDto {
    private Long id;
    private Integer version;
    private LocalDateTime createdDate;
    private String createdBy;
    private LocalDateTime lastModifiedDate;
    private String lastModifiedBy;
    private Boolean deleted;
    private PaymentType paymentType;
    private BigDecimal price;
    private Integer fromDate;
    private Integer toDate;
    private String description;
}
