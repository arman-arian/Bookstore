package com.tosan.bookstore.services;

import com.tosan.bookstore.dtos.inputs.*;
import com.tosan.bookstore.dtos.outputs.*;
import com.tosan.bookstore.exceptions.*;
import com.tosan.bookstore.models.*;
import com.tosan.bookstore.daos.UserRepository;
import com.tosan.bookstore.utils.enums.EnumUtils;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserService extends BaseService {
    private final UserRepository _userRepository;
    private final ModelMapper _modelMapper;
    private final PasswordEncoder _passwordEncoder;

    public UserService(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this._userRepository = userRepository;
        this._modelMapper = modelMapper;
        this._passwordEncoder = passwordEncoder;
    }

    public Map<Integer, String> GetUserTypes() {
        return EnumUtils.GetEnumNames(UserType.class);
    }

    public UserOutputDto GetUser(Long id) {
        User user = _userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new BookStoreException(BookStoreFaults.UserNotExists);
        }
        return _modelMapper.map(user, UserOutputDto.class);
    }

    public List<UserOutputDto> GetUsers() {
        List<UserOutputDto> outputDto = new ArrayList<>();
        List<User> users = (List<User>) _userRepository.findAll();
        for (User user : users) {
            outputDto.add(_modelMapper.map(user, UserOutputDto.class));
        }

        return outputDto;
    }

    public void Register(UserInputDto inputDto) {
        var user = _modelMapper.map(inputDto, User.class);
        user.setPassword(_passwordEncoder.encode(inputDto.getPassword()));
        user.setActive(true);

        _userRepository.save(user);
    }

    public void Update(UserInputDto inputDto) {
        User user = _userRepository.findById(inputDto.getId()).orElse(null);
        if (user == null) {
            throw new BookStoreException(BookStoreFaults.UserNotExists);
        }

        if (!user.getActive()) {
            throw new BookStoreException(BookStoreFaults.UserNotActive);
        }

        user.setName(inputDto.getName());
        user.setEmail(inputDto.getEmail());
        user.setAvatarUrl(inputDto.getAvatarUrl());

        _userRepository.save(user);
    }

    public LoginOutputDto Login(LoginInputDto inputDto) {
        User user = _userRepository.findByUsername(inputDto.getUsername());
        if (user == null) {
            throw new BookStoreException(BookStoreFaults.UserNotExists);
        }

        if (!user.getActive()) {
            throw new BookStoreException(BookStoreFaults.UserNotActive);
        }

        if (_passwordEncoder.matches(inputDto.getPassword(), user.getPassword())) {
            var outputDto = _modelMapper.map(user, LoginOutputDto.class);
            user.setLastLoginDate(LocalDateTime.now());
            _userRepository.save(user);
            return outputDto;
        } else {
            throw new BookStoreException(BookStoreFaults.UserLoginFailed);
        }
    }

    public void ChangePassword(ChangePasswordInputDto inputDto) {
        if (_passwordEncoder.matches(inputDto.getOldPassword(), inputDto.getNewPassword())) {
            throw new BookStoreException(BookStoreFaults.UserSameOldAndNewPassword);
        }

        User user = _userRepository.findByUsername(inputDto.getUsername());
        if (user == null) {
            throw new BookStoreException(BookStoreFaults.UserNotExists);
        }

        if (!user.getActive()) {
            throw new BookStoreException(BookStoreFaults.UserNotActive);
        }

        if (_passwordEncoder.matches(inputDto.getOldPassword(), user.getPassword())) {
            user.setPassword(inputDto.getNewPassword());
            _userRepository.save(user);
        } else {
            throw new BookStoreException(BookStoreFaults.UserLoginFailed);
        }
    }

    public void ResetPassword(ResetPasswordInputDto inputDto) {
        User user = _userRepository.findByUsername(inputDto.getUsername());
        if (user == null) {
            throw new BookStoreException(BookStoreFaults.UserNotExists);
        }

        if (!user.getActive()) {
            throw new BookStoreException(BookStoreFaults.UserNotActive);
        }

        user.setPassword(inputDto.getNewPassword());
        _userRepository.save(user);
    }

    public void ActiveUser(Long id) {
        User user = _userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new BookStoreException(BookStoreFaults.UserNotExists);
        }

        user.setActive(true);
        _userRepository.save(user);
    }

    public void DeActiveUser(Long id) {
        User user = _userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new BookStoreException(BookStoreFaults.UserNotExists);
        }

        user.setActive(false);
        _userRepository.save(user);
    }
}