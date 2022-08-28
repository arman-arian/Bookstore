package com.tosan.bookstore.dtos.outputs;

import com.tosan.bookstore.models.UserType;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginOutputDto implements Serializable {
    private Long id;
    private String username;
    private String name;
    private String email;
    private UserType userType;
    private LocalDateTime lastLoginDate;
}
