package com.tosan.bookstore.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Invoices")
public class Invoice {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private long userId;

    private LocalDate createdDate;

    private LocalDate issuedDate;

    private LocalDate paidDate;

    private long totalAmount;

    private InvoiceState state;

    @Column(length=200)
    private String description;
}
