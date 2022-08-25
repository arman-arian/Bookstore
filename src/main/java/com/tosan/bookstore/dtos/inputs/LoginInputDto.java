package com.tosan.bookstore.dtos.inputs;

//import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginInputDto implements Serializable {
   // @NotEmpty(message = "username is invalid")
    private String username;

    //@NotEmpty(message = "password is invalid")
    private String password;
}
