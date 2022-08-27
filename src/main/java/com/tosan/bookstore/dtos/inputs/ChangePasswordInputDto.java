package com.tosan.bookstore.dtos.inputs;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChangePasswordInputDto implements Serializable {
    private String username;
    private String oldPassword;
    private String newPassword;
}
