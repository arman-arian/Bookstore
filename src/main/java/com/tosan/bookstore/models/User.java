package com.tosan.bookstore.models;

import javax.persistence.*;
import java.time.*;

@Entity
@Table(name = "Users")
public class User {
        @Id
        @GeneratedValue
        private long id;

        @Column(length=40, nullable = false, unique = true)
        private String username;

        @Column(length=40, nullable = false)
        private String password;

        @Column(length=80)
        private String name;

        @Column(length=320)
        private String email;

        private UserTypes userTypes;

        private LocalDateTime creationDate;

        private LocalDateTime lastLoginDate;

        private boolean active;
}
