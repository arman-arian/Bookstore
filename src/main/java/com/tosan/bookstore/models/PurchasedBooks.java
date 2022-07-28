package com.tosan.bookstore.models;

import javax.persistence.*;
import java.time.*;

@Entity
@Table(name = "PurchasedBooks ")
public class PurchasedBooks {
    @Id
    @GeneratedValue
    private long id;

    private long userId;

    private long bookId;

    private long buyAmount;

    private LocalDate buyDate;

    public PurchasedBooks()
    {
    }

    public PurchasedBooks(long userId, long bookId, long buyAmount, LocalDate buyDate)
    {
        this.userId = userId;
        this.bookId = bookId;
        this.buyAmount = buyAmount;
        this.buyDate = buyDate;
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

    public long getBuyAmount() {
        return buyAmount;
    }

    public LocalDate getBuyDate() {
        return buyDate;
    }
}
