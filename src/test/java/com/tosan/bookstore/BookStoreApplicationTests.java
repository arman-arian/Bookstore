package com.tosan.bookstore;

import com.tosan.bookstore.dtos.inputs.*;
import com.tosan.bookstore.models.PaymentType;
import com.tosan.bookstore.services.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BookStoreApplicationTests {
    @Autowired
    public CategoryService categoryService;
    @Autowired
    public InvoiceService invoiceService;
    public PasswordEncoder passwordEncoder;


    @Test
    void contextLoad() {
        passwordEncoder = new BCryptPasswordEncoder();
    }

    @Test
    void testHashPassword() {
        var hashedPassword = passwordEncoder.encode("12345");
        assertThat(hashedPassword).isNotNull().isNotEmpty();
    }

    @Test
    void testLoadCategories()
    {
       var cats = categoryService.GetAllCategories();
       var id = cats.get(0).getId();
        assertThat(id).isGreaterThanOrEqualTo(0);
    }

    @Test
    void testAddDraftInvoice()
    {
        var invoice = new InvoiceItemInputDto();
        invoice.setUserId(1L);
        invoice.setFromDate(14000101);
        invoice.setToDate(14010101);
        invoice.setPaymentType(PaymentType.Buy);
        invoice.setPrice(1000L);
        invoice.setBookId(1L);
        invoiceService.AddToDraftInvoice(invoice);

        var invoices = invoiceService.GetInvoices(invoice.getUserId());
        assertThat(invoices.size()).isGreaterThan(0);
    }

}
