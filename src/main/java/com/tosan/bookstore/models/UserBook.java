package com.tosan.bookstore.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "User_Books")
@Getter
@Setter
public class UserBook extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_Id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_Id", nullable = false)
    private Book book;

    @Column(name = "begin_date", nullable = false)
    private Integer beginDate;

    @Column(name = "to_date")
    private Integer toDate;
}
