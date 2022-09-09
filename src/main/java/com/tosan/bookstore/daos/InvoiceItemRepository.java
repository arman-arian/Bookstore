package com.tosan.bookstore.daos;

import com.tosan.bookstore.models.InvoiceItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceItemRepository extends BaseRepository<InvoiceItem, Long>  {
    List<InvoiceItem> findByInvoiceId(Long invoiceId);
}
