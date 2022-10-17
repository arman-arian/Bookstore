package com.tosan.bookstore.dtos;

import com.tosan.bookstore.exceptions.BookStoreFaults;
import com.tosan.bookstore.utils.validators.Identity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IdDto extends BaseDto {
    private Long id;
}