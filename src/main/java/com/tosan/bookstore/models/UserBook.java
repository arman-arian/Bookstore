package com.tosan.bookstore.models;

import javax.persistence.*;

@Entity
@Table(name = "UserBooks ")
public class UserBook {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long bookId;

    @Column(nullable = false)
    private Integer beginDate;

    private Integer toDate;

    public UserBook() {
    }

    public UserBook(Long id, Long userId, Long bookId, Integer beginDate, Integer toDate) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.beginDate = beginDate;
        this.toDate = toDate;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public Integer getBeginDate() {
        return beginDate;
    }

    public Integer getToDate() {
        return toDate;
    }
}
