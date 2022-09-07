package com.tosan.bookstore.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Invoice_Items")
@Getter
@Setter
public class InvoiceItem extends BaseEntity {
    @Column(name = "payment_type")
    @Enumerated(EnumType.ORDINAL)
    private PaymentType paymentType;

    @Column(nullable = false)
    private Long price;

    @Column(name = "from_date", nullable = false)
    private Integer fromDate;

    @Column(name = "to_date")
    private Integer toDate;

    @Column(length = 200)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_Id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "invoice_Id", nullable = false)
    private Invoice invoice;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_Id", nullable = false)
    private Book book;

    public InvoiceItem() {
    }

    public InvoiceItem(Long id) {
        this.setId(id);
    }

}
