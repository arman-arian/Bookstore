package com.tosan.bookstore.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Invoice_Items")
@Getter
@Setter
public class InvoiceItem extends BaseEntity {
    private Integer quantity;

    @Column(nullable = false)
    private Long price;

    @Column(length = 200)
    private String description;

    @Column(name = "payment_type")
    @Enumerated(EnumType.ORDINAL)
    private PaymentType paymentType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "invoice_Id", nullable = false)
    private Invoice invoice;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_Id", nullable = false)
    private Book book;
}
