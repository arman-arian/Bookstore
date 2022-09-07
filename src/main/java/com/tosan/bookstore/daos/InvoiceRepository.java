package com.tosan.bookstore.daos;

import com.tosan.bookstore.models.Invoice;
import com.tosan.bookstore.models.InvoiceState;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InvoiceRepository extends BaseRepository<Invoice, Long> {
    Optional<Invoice> findByUserIdAndState(Long userId, InvoiceState state);

    List<Invoice> findByUserId(Long userId);
}
