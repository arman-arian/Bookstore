package com.tosan.bookstore.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Invoices")
@Getter
@Setter
public class Invoice extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_Id", nullable = false)
    private User user;

    private LocalDate issuedDate;

    private LocalDate paidDate;

    @Column(nullable = false)
    private Long totalAmount;

    @Column(nullable = false)
    private InvoiceState state;

    @Column(length = 200)
    private String description;

    @OneToMany(mappedBy = "invoice", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<InvoiceItem> invoiceItems;
}
