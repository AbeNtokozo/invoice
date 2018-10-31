package za.co.digitalplatoon.inoiceservice.invoice.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name="invoice")
public class Invoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "invoiceId", unique = true, nullable = false)
	private Long invoiceId;
	
	@Column(name = "client", nullable = false)
	private String client;
	
	@Column(name = "vatRate", nullable = false)
	private Long vatRate;
	
	@Column(name = "invoiceDate", nullable = false)
	@CreatedDate	
	private Date invoiceDate;
	
	@OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<LineItem> lineItems;

	
	public Invoice() {
		super();
	}
	
	
	public Invoice(Long invoiceId, String client, Long vatRate, Date invoiceDate, Set<LineItem> lineItems) {
		super();
		this.invoiceId = invoiceId;
		this.client = client;
		this.vatRate = vatRate;
		this.invoiceDate = invoiceDate;
		this.lineItems = lineItems;
	}

	
	public Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}
		
	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Long getVatRate() {
		return vatRate;
	}

	public void setVatRate(Long vatRate) {
		this.vatRate = vatRate;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	
	public Set<LineItem> getLineItems() {
		return lineItems;
	}


	public void setLineItems(Set<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
	
	public String getLineItemTotal() {
		Long line = new Long(lineItems.size());
		BigDecimal total = new BigDecimal(line++);
		return total.setScale(2, RoundingMode.HALF_UP).toString();
	}
	
	public String getSubTotal() {
		
		BigDecimal subTotal = new BigDecimal(0);
		
		for(LineItem item: lineItems) {
			
			BigDecimal quantity = new BigDecimal(item.getQuantity());
			BigDecimal total = new BigDecimal(0);
			
			quantity = quantity.add(quantity);
			total = total.add(item.getUnitPrice());
			subTotal = quantity.subtract(total);
			
		}	
		return subTotal.setScale(2, RoundingMode.HALF_UP).toString();
	}
	
	public String getVat() {
		BigDecimal vat = new BigDecimal(vatRate);
		return vat.setScale(2, RoundingMode.HALF_UP).toString();
	}
		
	public String getTotal() {
		BigDecimal total = new BigDecimal(0);	
		for(LineItem item: lineItems) {
			total = total.add(item.getUnitPrice());
		}	
		return total.setScale(2, RoundingMode.HALF_UP).toString();
	}

	@Override
	public String toString() {
		return String.format("Invoice [id=%s, client=%s, vatRate=%s, invoiceDate=%s]", invoiceId, client, vatRate, invoiceDate);
	}


}
