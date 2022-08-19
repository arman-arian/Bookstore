package com.tosan.bookstore.daos;

import com.tosan.bookstore.models.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {
    User findByUsername(String username);
}