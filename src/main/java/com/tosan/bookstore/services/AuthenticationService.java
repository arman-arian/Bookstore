package com.tosan.bookstore.services;

import com.tosan.bookstore.daos.UserRepository;
import com.tosan.bookstore.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AuthenticationService extends BaseService implements UserDetailsService {
    private final  UserRepository _userRepository;

    public AuthenticationService(UserRepository userRepository) {
        _userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = _userRepository.findByUsername(username).orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException("user not exists");
        }

        return user;
    }

    public void logFailedLogin(String username) {
        try {
            var user = _userRepository.findByUsername(username).orElse(null);
            if (user == null) {
                return;
            }

            if (user.isEnabled() && user.isAccountNonLocked()) {
                if (user.isFailedAttemptsExceeded()) {
                    user.lock();
                } else {
                    user.increaseFailedAttempts();
                }
            } else if (!user.isAccountNonLocked()) {
                if (user.isLockTimeFinished()) {
                    user.unlock();
                }
            }

            _userRepository.save(user);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void logSuccessfulLogin(String username) {
        try {
            var user = _userRepository.findByUsername(username).orElse(null);
            if (user == null) {
                return;
            }

            user.setFailedAttempt(0);
            user.setLastLoginDate(LocalDateTime.now());

            _userRepository.save(user);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public User loadCurrentUser() {
        var context = SecurityContextHolder.getContext();
        if(context == null)
            return null;

        var authentication = context.getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }

        var principal = authentication.getPrincipal();
        if (principal == null) {
            return null;
        }

        return (User) principal;
    }

    public Optional<String> loadCurrentUsername() {
        var user = loadCurrentUser();
        if(user == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(user.getUsername());
    }
}
