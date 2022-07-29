package com.tosan.bookstore.daos;

import com.tosan.bookstore.models.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {
}
