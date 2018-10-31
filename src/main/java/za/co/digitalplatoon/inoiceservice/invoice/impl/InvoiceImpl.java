package za.co.digitalplatoon.inoiceservice.invoice.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import za.co.digitalplatoon.inoiceservice.invoice.entity.Invoice;
import za.co.digitalplatoon.inoiceservice.invoice.entity.LineItem;
import za.co.digitalplatoon.inoiceservice.invoice.repo.InvoiceRepository;
import za.co.digitalplatoon.inoiceservice.invoice.repo.LineItemRepository;
import za.co.digitalplatoon.inoiceservice.invoice.service.InvoiceService;

@Service
@Component
public class InvoiceImpl implements InvoiceService{
	
	@Autowired
	InvoiceRepository invoiceRepository;
	
	@Autowired
	LineItemRepository lineItemRepository;
	
	
	@Override
	public Iterable<Invoice> getAllInvoices() {
		Iterable<Invoice> invoices = invoiceRepository.findAll();
		return invoices;
	}
	
	@Override
	public Invoice getInvoice(Long id){
		Optional<Invoice> invoice = invoiceRepository.findById(id);
		return invoice.get();
	}
	
	@Override
	public void addInvoice(Invoice invoice) {
	
		invoiceRepository.save(invoice);
		
		for(LineItem item: invoice.getLineItems()) {
			item.setInvoice(invoice);
			lineItemRepository.save(item);
		}
	
	}
	
}
