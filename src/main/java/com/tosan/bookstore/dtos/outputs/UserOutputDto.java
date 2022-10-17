package com.tosan.bookstore.dtos.outputs;

import com.tosan.bookstore.models.UserState;
import com.tosan.bookstore.models.UserType;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserOutputDto extends BaseOutputDto  {
    private Long id;
    private LocalDateTime createdDate;
    private String createdBy;
    private LocalDateTime lastModifiedDate;
    private String lastModifiedBy;
    private Boolean deleted = false;
    private String username;
    private String name;
    private String email;
    private UserType userType;
    private LocalDateTime lastLoginDate;
    private UserState userState;
}
