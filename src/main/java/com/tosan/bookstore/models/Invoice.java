package com.tosan.bookstore.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Invoices")
@Getter
@Setter
public class Invoice extends BaseEntity {
    @Column(name = "issued_date")
    private LocalDate issuedDate;

    @Column(name = "paid_date")
    private LocalDate paidDate;

    @Column(name = "total_amount", nullable = false)
    private Long totalAmount;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private InvoiceState state;

    @Column(length = 200)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_Id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "invoice", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<InvoiceItem> invoiceItems = new HashSet<>();

    public void addInvoiceItem(InvoiceItem invoiceItem) {
        getInvoiceItems().add(invoiceItem);
    }
}
