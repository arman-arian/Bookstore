package com.tosan.bookstore.services;

import com.tosan.bookstore.daos.InvoiceRepository;
import com.tosan.bookstore.dtos.inputs.*;
import com.tosan.bookstore.dtos.outputs.*;
import com.tosan.bookstore.exceptions.*;
import com.tosan.bookstore.models.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceService extends BaseService {
    private final ModelMapper _modelMapper;
    private final InvoiceRepository _invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository, ModelMapper modelMapper) {
        this._invoiceRepository = invoiceRepository;
        this._modelMapper = modelMapper;
    }

    public List<InvoiceOutputDto> GetInvoices(Long userId) {
        var outputDto = new ArrayList<InvoiceOutputDto>();
        var invoices = _invoiceRepository.findByUserId(userId);
        for (var invoice : invoices) {
            outputDto.add(_modelMapper.map(invoice, InvoiceOutputDto.class));
        }

        return outputDto;
    }

    public List<InvoiceItemOutputDto> GetInvoiceItems(Long invoiceId) {
        var outputDto = new ArrayList<InvoiceItemOutputDto>();
        var invoice = _invoiceRepository.findById(invoiceId).orElse(null);
        if (invoice == null) {
            throw new BookStoreException(BookStoreFaults.InvoiceNotExists);
        }

        for (var invoiceItem : invoice.getInvoiceItems()) {
            outputDto.add(_modelMapper.map(invoiceItem, InvoiceItemOutputDto.class));
        }

        return outputDto;
    }

    public List<InvoiceItemOutputDto> GetDraftInvoice(Long userId) {
        var outputDto = new ArrayList<InvoiceItemOutputDto>();
        var invoice = _invoiceRepository.findByUserIdAndState(userId, InvoiceState.Draft).orElse(null);
        if (invoice == null)
            return outputDto;
        for (var invoiceItem : invoice.getInvoiceItems()) {
            outputDto.add(_modelMapper.map(invoiceItem, InvoiceItemOutputDto.class));
        }

        return outputDto;
    }

    public void AddToDraftInvoice(InvoiceItemInputDto inputDto) {
        var userRef = new User(inputDto.getUserId());
        var bookRef = new Book(inputDto.getBookId());

        var invoiceItem = _modelMapper.map(inputDto, InvoiceItem.class);
        invoiceItem.setUser(userRef);
        invoiceItem.setBook(bookRef);

        var draftInvoice = _invoiceRepository
                .findByUserIdAndState(inputDto.getUserId(), InvoiceState.Draft).orElse(null);
        if (draftInvoice != null) {
            draftInvoice.addInvoiceItem(invoiceItem);
            _invoiceRepository.save(draftInvoice);
            return;
        }

        var newInvoice = new Invoice();
        newInvoice.setUser(userRef);
        newInvoice.setState(InvoiceState.Draft);
        newInvoice.setTotalAmount(0L);
        newInvoice.addInvoiceItem(invoiceItem);

        _invoiceRepository.save(newInvoice);
    }

    public void DeleteFromDraftInvoice(Long invoiceId, Long invoiceItemId) {
        var invoice = _invoiceRepository.findById(invoiceId).orElse(null);
        if (invoice == null) {
            throw new BookStoreException(BookStoreFaults.InvoiceNotExists);
        }

        var invoiceItemRef = new InvoiceItem(invoiceItemId);
        invoice.removeInvoiceItem(invoiceItemRef);

        _invoiceRepository.save(invoice);
    }

    public void IssueInvoice(Long invoiceId) {
        var invoice = _invoiceRepository.findById(invoiceId).orElse(null);
        if (invoice == null) {
            throw new BookStoreException(BookStoreFaults.InvoiceNotExists);
        }

        invoice.setState(InvoiceState.Issued);
        invoice.setIssuedDate(LocalDate.now());

        _invoiceRepository.save(invoice);
    }

    public void CancelInvoice(Long invoiceId) {
        var invoice = _invoiceRepository.findById(invoiceId).orElse(null);
        if (invoice == null) {
            throw new BookStoreException(BookStoreFaults.InvoiceNotExists);
        }

        invoice.setState(InvoiceState.Cancelled);

        _invoiceRepository.save(invoice);
    }

    public void DeleteInvoice(Long invoiceId) {
        var invoice = _invoiceRepository.findById(invoiceId).orElse(null);
        if (invoice == null) {
            throw new BookStoreException(BookStoreFaults.InvoiceNotExists);
        }

        invoice.setState(InvoiceState.Deleted);

        _invoiceRepository.save(invoice);
    }

    public void ExpireInvoice(Long invoiceId) {
        var invoice = _invoiceRepository.findById(invoiceId).orElse(null);
        if (invoice == null) {
            throw new BookStoreException(BookStoreFaults.InvoiceNotExists);
        }

        invoice.setState(InvoiceState.Expired);

        _invoiceRepository.save(invoice);
    }

    public void PayInvoice(Long invoiceId) {
        var invoice = _invoiceRepository.findById(invoiceId).orElse(null);
        if (invoice == null) {
            throw new BookStoreException(BookStoreFaults.InvoiceNotExists);
        }

        invoice.setState(InvoiceState.Expired);
        invoice.setPaidDate(LocalDate.now());

        _invoiceRepository.save(invoice);
    }
}