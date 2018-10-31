package za.co.digitalplatoon.inoiceservice.invoice.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import za.co.digitalplatoon.inoiceservice.invoice.entity.Invoice;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Long>{

}
