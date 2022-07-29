package com.tosan.bookstore.models;

import javax.persistence.*;

@Entity
@Table(name = "UserBooks ")
public class UserBook {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private long userId;

    @Column(nullable = false)
    private long bookId;

    @Column(nullable = false)
    private Integer beginDate;

    private Integer toDate;

    public UserBook() {
    }

    public UserBook(long id, long userId, long bookId, int beginDate, int toDate) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.beginDate = beginDate;
        this.toDate = toDate;
    }

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public long getBookId() {
        return bookId;
    }

    public int getBeginDate() {
        return beginDate;
    }

    public int getToDate() {
        return toDate;
    }
}
