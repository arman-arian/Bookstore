package com.tosan.bookstore;

import com.tosan.bookstore.services.CategoryService;
import com.tosan.bookstore.utils.dates.PersianDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class BookStoreApplicationTests {
    @Test
    void contextLoad() {
       // var result = PersianDate.now().toString("D");
    }

//    @Test
//    void testHashPassword() {
//        PasswordEncoder _passwordEncoder = new BCryptPasswordEncoder();
//        var result = _passwordEncoder.encode("12345");
//    }

    @Autowired
    public CategoryService categoryService;

    @Test
    void TestLoadCategories()
    {
       var cats = categoryService.GetAllCategories();
       var x = cats.get(0).getId();
    }

}
