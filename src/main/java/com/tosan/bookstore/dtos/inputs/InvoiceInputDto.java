package com.tosan.bookstore.dtos.inputs;

import com.tosan.bookstore.models.PaymentType;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InvoiceInputDto extends BaseInputDto {
    private Long id;
    private Integer version;
    private LocalDateTime createdDate;
    private String createdBy;
    private LocalDateTime lastModifiedDate;
    private String lastModifiedBy;
    private Boolean deleted;
    private PaymentType paymentType;
    private Long price;
    private Integer fromDate;
    private Integer toDate;
    private String description;
}
