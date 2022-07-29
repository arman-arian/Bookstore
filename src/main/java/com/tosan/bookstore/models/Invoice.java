package com.tosan.bookstore.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Invoices")
public class Invoice {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private LocalDate createdDate;

    private LocalDate issuedDate;

    private LocalDate paidDate;

    @Column(nullable = false)
    private Long totalAmount;

    @Column(nullable = false)
    private InvoiceState state;

    @Column(length=200)
    private String description;

    public Invoice() {
    }

    public Invoice(Long id, Long userId, String description) {
        this.id = id;
        this.userId = userId;
        this.createdDate = LocalDate.now();
        this.issuedDate = null;
        this.paidDate = null;
        this.totalAmount = 0L;
        this.state = InvoiceState.Draft;
        this.description = description;
    }
}
