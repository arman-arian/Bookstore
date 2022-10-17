package com.tosan.bookstore.models;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.*;
import java.util.*;

@Entity
@Table(name = "Users")
@Getter
@Setter
public class User extends BaseEntity implements UserDetails {
        private static final int PASSWORD_EXPIRATION_TIME = 30;
        private static final int MAX_FAILED_ATTEMPTS = 3;
        private static final int LOCK_TIME_DURATION = 24; // 24 hours


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

        @Column(name = "last_password_changed_date")
        private LocalDateTime lastPasswordChangedDate;

        @Column(name = "user_state")
        @Enumerated(EnumType.ORDINAL)
        private UserState userState;

        @Column(name = "failed_attempt")
        private int failedAttempt;

        @Column(name = "lock_time")
        private LocalDateTime lockTime;

        @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private Set<Invoice> invoices = new HashSet<>();

        public User() {
        }

        public User(Long id) {
                setId(id);
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
                List<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority(getUserType().toString()));
                return authorities;
        }

        @Override
        public boolean isAccountNonExpired() {
                return getUserState() != UserState.Expired;
        }

        @Override
        public boolean isAccountNonLocked() {
                return getUserState() != UserState.Locked;
        }

        @Override
        public boolean isCredentialsNonExpired() {
                if (getLastPasswordChangedDate() == null) return true;
                var currentDate = LocalDateTime.now();
                var lastChangedDate = getLastPasswordChangedDate();

                return currentDate.isBefore(lastChangedDate.plusDays(PASSWORD_EXPIRATION_TIME));
        }

        @Override
        public boolean isEnabled() {
                return getUserState() == UserState.Enabled;
        }

        public void unlock() {
                setFailedAttempt(0);
                setLockTime(null);
                setUserState(UserState.Enabled);
        }

        public void lock() {
                setLockTime(LocalDateTime.now());
                setUserState(UserState.Locked);
        }

        public void increaseFailedAttempts() {
                setFailedAttempt(getFailedAttempt() + 1);
        }

        public boolean isFailedAttemptsExceeded() {
                return getFailedAttempt() > User.MAX_FAILED_ATTEMPTS - 1;
        }

        public boolean isLockTimeFinished() {
                return getLockTime().plusHours(LOCK_TIME_DURATION).isAfter(LocalDateTime.now());
        }

        @Override
        public String toString() {
                return getName();
        }
}