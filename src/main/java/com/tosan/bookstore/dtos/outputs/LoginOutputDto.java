package com.tosan.bookstore.dtos.outputs;

import com.tosan.bookstore.models.UserType;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginOutputDto  extends BaseOutputDto  {
    private Long id;
    private String username;
    private String name;
    private String email;
    private UserType userType;
    private LocalDateTime lastLoginDate;
}
