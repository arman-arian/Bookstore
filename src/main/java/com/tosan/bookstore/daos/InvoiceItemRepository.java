package com.tosan.bookstore.daos;

import com.tosan.bookstore.models.InvoiceItem;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceItemRepository extends BaseRepository<InvoiceItem, Long>  {
}
