package com.tosan.bookstore.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/invoices")
public class InvoiceController {
    private final InvoiceController repository;

    public InvoiceController(InvoiceController repository) {
        this.repository = repository;
    }
}
