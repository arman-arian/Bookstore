package com.tosan.bookstore.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "InvoiceItems")
public class InvoiceItem {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Long invoiceId;

    @Column(nullable = false)
    private Long bookId;

    private Integer quantity;

    @Column(nullable = false)
    private Long price;

    @Column(length = 200)
    private String description;

    private LocalDateTime lastChanged;
}
