package com.tosan.bookstore.models;

import javax.persistence.*;
import java.time.*;

@Entity
@Table(name = "RentedBooks ")
public class RentedBooks {
    @Id
    @GeneratedValue
    private long id;

    private long userId;

    private long bookId;

    private long rentAmount;

    private LocalDate rentFromDate;

    private LocalDate rentToDate;

    public RentedBooks() {
    }

    public RentedBooks(long userId, long bookId, long rentAmount, LocalDate rentFromDate, LocalDate rentToDate) {
        this.userId = userId;
        this.bookId = bookId;
        this.rentAmount = rentAmount;
        this.rentFromDate = rentFromDate;
        this.rentToDate = rentToDate;
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

    public long getRentAmount() {
        return rentAmount;
    }

    public LocalDate getRentFromDate() {
        return rentFromDate;
    }

    public LocalDate getRentToDate() {
        return rentToDate;
    }
}
