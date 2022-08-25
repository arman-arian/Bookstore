package com.tosan.bookstore.models;

import lombok.*;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.time.*;
import java.util.Set;

@Entity
@Table(name = "Users")
@Getter
@Setter
public class User extends BaseEntity {
        @Column(length = 40, nullable = false, unique = true)
        private String username;

        @Column(length = 256, nullable = false)
        private String password;

        @Column(length = 80)
        private String name;

        @Column(length = 320, unique = true)
        private String email;

        @Column(name = "user_type", nullable = false)
        @Enumerated(EnumType.ORDINAL)
        private UserType userType;

        @Column(name = "last_login_date")
        private LocalDateTime lastLoginDate;

        @Column(nullable = false)
        private Boolean active;

        @Column(name = "avatar_url", length = 400)
        private String avatarUrl;

        @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private Set<Invoice> invoices;
}