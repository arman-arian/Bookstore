package com.tosan.bookstore.dtos.inputs;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginInputDto extends BaseInputDto {
    @NotEmpty(message = "{BookStoreFaults.UserEmptyUsername}")
    private String username;

    @NotEmpty(message = "{BookStoreFaults.UserEmptyPassword}")
    private String password;
}
