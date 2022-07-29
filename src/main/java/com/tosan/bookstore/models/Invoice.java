package com.tosan.bookstore.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Column(nullable = false)
    private LocalDate createdDate;

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

    public Invoice() {
    }

    public Invoice(Long id, String description) {
        this.id = id;
        this.createdDate = LocalDate.now();
        this.issuedDate = null;
        this.paidDate = null;
        this.totalAmount = 0L;
        this.state = InvoiceState.Draft;
        this.description = description;
    }
}
