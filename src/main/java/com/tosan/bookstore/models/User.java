package com.tosan.bookstore.models;

import javax.persistence.*;
import java.time.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(length = 40, nullable = false, unique = true)
        private String username;

        @Column(length = 40, nullable = false)
        private String password;

        @Column(length = 80)
        private String name;

        @Column(length = 320)
        private String email;

        @Column(nullable = false)
        private UserType userType;

        @Column(nullable = false)
        private LocalDateTime creationDate;

        private LocalDateTime lastLoginDate;

        @Column(nullable = false)
        private Boolean active;

        @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private Set<UserBook> userBooks;

        public User() {
        }

        public User(String username, String password, String name, String email, UserType userTypes) {
                this.username = username;
                this.password = password;
                this.name = name;
                this.email = email;
                this.userType = userTypes;
                this.creationDate = LocalDateTime.now();
                this.lastLoginDate = null;
                this.active = true;
        }

        public Long getId() {
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
                return userType;
        }

        public LocalDateTime getCreationDate() {
                return creationDate;
        }

        public LocalDateTime getLastLoginDate() {
                return lastLoginDate;
        }

        public Boolean isActive() {
                return active;
        }

        @Override
        public String toString() {
                return getUsername();
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                User user = (User) o;
                return username.equals(user.username);
        }

        @Override
        public int hashCode() {
                return Objects.hash(username);
        }
}
