package com.tosan.bookstore;

import com.tosan.bookstore.dtos.IdDto;
import com.tosan.bookstore.dtos.inputs.*;
import com.tosan.bookstore.models.PaymentType;
import com.tosan.bookstore.services.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.math.BigDecimal;
import java.util.Set;



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
        invoice.setPrice(BigDecimal.valueOf(1000));
        invoice.setBookId(1L);
        invoiceService.AddToDraftInvoice(invoice);

        var invoices = invoiceService.GetInvoices(invoice.getUserId());
        assertThat(invoices.size()).isGreaterThan(0);
    }

    @Test
    void testUpdateSubCategory()
    {
        var subCat = new SubCategoryInputDto();
        subCat.setName("Test");
        subCat.setSubCategoryId(1L);
        subCat.setCategoryId(1L);
        categoryService.UpdateSubCategory(subCat);

        var subCat2 = categoryService.GetSubCategories(1L);
    }

    @Test
    void validateInput() {
        var input = new IdDto();
        input.setId(-100L);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        var validator = factory.getValidator();
        Set<ConstraintViolation<IdDto>> violations = validator.validate(input);
    }
}
