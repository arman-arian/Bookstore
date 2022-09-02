package com.tosan.bookstore.dtos.inputs;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChangePasswordInputDto extends BaseInputDto {
    private String username;
    private String oldPassword;
    private String newPassword;
}
