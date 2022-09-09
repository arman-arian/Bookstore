package com.tosan.bookstore.dtos.inputs;

import com.tosan.bookstore.models.PaymentType;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InvoiceItemInputDto extends BaseInputDto {
    private Long invoiceItemId;
    private PaymentType paymentType;
    private BigDecimal price;
    private Integer fromDate;
    private Integer toDate;
    private String description;
    private Long userId;
    private Long bookId;
}
