package com.tosan.bookstore.models;

import lombok.Getter;
import lombok.Setter;
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

        @Column(length = 40, nullable = false)
        private String password;

        @Column(length = 80)
        private String name;

        @Column(length = 320, unique = true)
        private String email;

        @Column(nullable = false)
        private UserType userType;

        private LocalDateTime lastLoginDate;

        @Column(nullable = false)
        private Boolean active;

        @Lazy
        @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private Set<UserBook> userBooks;

        public boolean verifyPassword(String password) {
                return this.password.equals(password);
        }
}