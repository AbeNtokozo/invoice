package za.co.digitalplatoon.inoiceservice.invoice.service;


import za.co.digitalplatoon.inoiceservice.invoice.entity.Invoice;

public interface InvoiceService {
	
	public Iterable<Invoice> getAllInvoices();
	
	public Invoice getInvoice(Long id);
	
	public void addInvoice(Invoice invoice);

}
