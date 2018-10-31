package za.co.digitalplatoon.inoiceservice.invoice.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="lineitem")
public class LineItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lineitemId", unique = true, nullable = false)
	private Long lineitemId;
	
	@Column(name = "quantity", nullable = false)
	private Long quantity;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "unitPrice", nullable = false)
	private BigDecimal unitPrice;
	
		
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "invoice_id")
	 @JsonIgnore
	 private Invoice invoice;

	public LineItem() {
		super();
	}

	public LineItem(Long lineitemId, Long quantity, String description, BigDecimal unitPrice, Invoice invoice) {
		super();
		this.lineitemId = lineitemId;
		this.quantity = quantity;
		this.description = description;
		this.unitPrice = unitPrice;
		this.invoice = invoice;
	}

	
	
	public Long getLineitemId() {
		return lineitemId;
	}

	public void setLineitemId(Long lineitemId) {
		this.lineitemId = lineitemId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	
	@Override
	public String toString() {
		return String.format("LineItem [lineItemId=%s, quantity=%s, description=%s, unitPrice=%s]", lineitemId, quantity, description, unitPrice);
	}


}
