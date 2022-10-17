package com.tosan.bookstore.dtos.inputs;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginInputDto extends BaseInputDto {
    private String username;

    private String password;
}
