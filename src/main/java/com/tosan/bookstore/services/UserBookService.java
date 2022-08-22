package com.tosan.bookstore.services;

import com.tosan.bookstore.daos.UserRepository;
import com.tosan.bookstore.exceptions.GeneralException;
import com.tosan.bookstore.models.User;
import org.modelmapper.ModelMapper;

public class UserBookService {
    private final UserRepository repository;
    private final ModelMapper modelMapper;

    public UserBookService(UserRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public void GetUserBooks(long userId)
    {
        try {
            User user = repository.findById(userId).orElse(null);
            if (user == null)
                throw new GeneralException("1000", "User not exists");

            var userBooks = user.getUserBooks();
            for(var userBook : userBooks)
            {

            }
        }
        catch (Exception ex)
        {
            throw new GeneralException("1003", "GetUserBooks Error", ex);
        }
    }
}
