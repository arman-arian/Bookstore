package com.tosan.bookstore.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "InvoiceItems")
public class InvoiceItem {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private long invoiceId;

    @Column(nullable = false)
    private long bookId;

    private Integer quantity;

    @Column(nullable = false)
    private long price;

    @Column(length=200)
    private String description;

    private LocalDateTime lastChanged;
}
