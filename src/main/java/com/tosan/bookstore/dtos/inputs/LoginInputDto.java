package com.tosan.bookstore.dtos.inputs;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginInputDto implements Serializable {
    @NotEmpty(message = "username is invalid")
    private String username;

    @NotEmpty(message = "password is invalid")
    private String password;
}
