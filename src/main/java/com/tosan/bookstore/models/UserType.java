package com.tosan.bookstore.models;

import com.tosan.bookstore.utils.enums.EnumDescription;

public enum UserType implements BaseEnum {
    @EnumDescription("کاربر عادی")
    User,
    @EnumDescription("عضو کتابخانه")
    Member,
    @EnumDescription("کتابدار")
    Librarian
}
