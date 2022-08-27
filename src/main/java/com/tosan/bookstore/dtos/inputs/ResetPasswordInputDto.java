package com.tosan.bookstore.dtos.inputs;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResetPasswordInputDto implements Serializable {
    private String username;
    private String newPassword;
}
