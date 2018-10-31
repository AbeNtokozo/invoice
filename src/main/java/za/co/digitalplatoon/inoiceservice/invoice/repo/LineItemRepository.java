package za.co.digitalplatoon.inoiceservice.invoice.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import za.co.digitalplatoon.inoiceservice.invoice.entity.LineItem;

@Repository
public interface LineItemRepository extends CrudRepository<LineItem, Long>{
	
}
