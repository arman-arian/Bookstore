package com.tosan.bookstore.dtos.inputs;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResetPasswordInputDto extends BaseInputDto {
    private String username;
    private String newPassword;
}
