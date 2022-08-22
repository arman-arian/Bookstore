package com.tosan.bookstore.controllers;

import com.tosan.bookstore.daos.InvoiceRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/invoices")
public class InvoiceController {
    public InvoiceController() {
    }
}
