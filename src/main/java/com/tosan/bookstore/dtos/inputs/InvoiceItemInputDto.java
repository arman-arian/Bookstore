package com.tosan.bookstore.dtos.inputs;

import com.tosan.bookstore.models.PaymentType;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InvoiceItemInputDto extends BaseInputDto {
    private PaymentType paymentType;
    private Long price;
    private Integer fromDate;
    private Integer toDate;
    private String description;
    private Long userId;
    private Long bookId;
}
