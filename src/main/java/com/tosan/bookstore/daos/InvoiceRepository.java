package com.tosan.bookstore.daos;

import com.tosan.bookstore.models.Invoice;
import com.tosan.bookstore.models.InvoiceState;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends BaseRepository<Invoice, Long> {
    Invoice findByState(InvoiceState state);
}
