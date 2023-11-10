package org.iir.billingservice.repository;

import org.iir.billingservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Product,Long> {
}
21