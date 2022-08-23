package com.tosan.bookstore.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "User_Books")
@Getter
@Setter
public class UserBook extends BaseEntity {
    @Column(name = "from_date", nullable = false)
    private Integer fromDate;

    @Column(name = "to_date")
    private Integer toDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_Id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_Id", nullable = false)
    private Book book;
}
