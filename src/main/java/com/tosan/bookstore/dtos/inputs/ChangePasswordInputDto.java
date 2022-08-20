package com.tosan.bookstore.dtos.inputs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
