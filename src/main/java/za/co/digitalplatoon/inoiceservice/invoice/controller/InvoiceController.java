package za.co.digitalplatoon.inoiceservice.invoice.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import za.co.digitalplatoon.inoiceservice.invoice.entity.Invoice;
import za.co.digitalplatoon.inoiceservice.invoice.service.InvoiceService;


@RestController
public class InvoiceController {
	
	@Autowired
	@Qualifier("invoiceImpl")
	InvoiceService invoiceService;
	
	public InvoiceService getInvoiceService() {
		return invoiceService;
	}
	
	@ResponseBody
	@GetMapping("/invoices/{id}")
	public Invoice getInvoice(@PathVariable(name="id")Long id)  throws Exception{
		Invoice invoice = invoiceService.getInvoice(id);
		return invoice;
	}
	
	@ResponseBody
	@GetMapping("/invoices")
	public List<Invoice> getAllInvoices() {
		return (List<Invoice>)invoiceService.getAllInvoices();
	}
	
	@ResponseBody
	@PostMapping("/invoices")
	public void saveInvoice(@Valid @RequestBody Invoice invoice) {
		invoiceService.addInvoice(invoice);
	}

}