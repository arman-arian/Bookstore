package com.tosan.bookstore.dtos.inputs;

import com.tosan.bookstore.models.UserType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserInputDto extends BaseInputDto {
    private Long userId;
    private String username;
    private String password;
    private String name;
    private String email;
    private UserType userType;
    private String avatarUrl;
}