package com.tosan.bookstore.dtos.inputs;

import com.tosan.bookstore.models.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserInputDto implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String email;
    private UserType userType;
}