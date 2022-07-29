package com.tosan.bookstore;

import com.tosan.bookstore.utils.PersianDate;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookStoreApplicationTests {

    @Test
    void contextLoads() {
       var result = PersianDate.now().toString("D");
    }

}
