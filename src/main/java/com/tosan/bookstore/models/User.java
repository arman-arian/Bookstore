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

        @Column(nullable = false)
        private UserType userTypes;

        @Column(nullable = false)
        private LocalDateTime creationDate;

        private LocalDateTime lastLoginDate;

        @Column(nullable = false)
        private boolean active;

        public User() {
        }

        public User(String username, String password, String name, String email, UserType userTypes) {
                this.username = username;
                this.password = password;
                this.name = name;
                this.email = email;
                this.userTypes = userTypes;
                this.creationDate = LocalDateTime.now();
                this.lastLoginDate = null;
                this.active = true;
        }

        public long getId() {
                return id;
        }

        public String getUsername() {
                return username;
        }

        public String getPassword() {
                return password;
        }

        public String getName() {
                return name;
        }

        public String getEmail() {
                return email;
        }

        public UserType getUserTypes() {
                return userTypes;
        }

        public LocalDateTime getCreationDate() {
                return creationDate;
        }

        public LocalDateTime getLastLoginDate() {
                return lastLoginDate;
        }

        public boolean isActive() {
                return active;
        }
}
