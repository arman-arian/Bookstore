package com.tosan.bookstore.models;

import javax.persistence.*;

@Entity
@Table(name = "UserBooks ")
public class UserBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bookId", nullable = false)
    private Book book;

    @Column(nullable = false)
    private Integer beginDate;

    private Integer toDate;

    public UserBook() {
    }

    public UserBook(Long id, Integer beginDate, Integer toDate) {
        this.id = id;
        this.beginDate = beginDate;
        this.toDate = toDate;
    }

    public Long getId() {
        return id;
    }

    public Integer getBeginDate() {
        return beginDate;
    }

    public Integer getToDate() {
        return toDate;
    }
}
