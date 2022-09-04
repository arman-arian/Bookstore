package com.tosan.bookstore.services;

import com.tosan.bookstore.daos.InvoiceRepository;
import com.tosan.bookstore.dtos.outputs.*;
import com.tosan.bookstore.models.InvoiceState;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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

    public List<InvoiceItemOutputDto> GetDraftInvoice(Long userId) {
        var outputDto = new ArrayList<InvoiceItemOutputDto>();
        var invoice = _invoiceRepository.findByUserIdAndState(userId, InvoiceState.Draft);
        if(invoice == null)
            return outputDto;

        for (var invoiceItem : invoice.getInvoiceItems()) {
            outputDto.add(_modelMapper.map(invoiceItem, InvoiceItemOutputDto.class));
        }

        return outputDto;
    }

    public void GetInvoices() {
    }

    public void GetInvoiceWithItems() {
    }

    public void AddInvoice() {
    }

    public void AddInvoiceItem() {
    }

    public void DeleteInvoice() {
    }

    public void DeleteInvoiceItem() {
    }

    public void UpdateInvoiceItem() {
    }
}
