package org.iir.billingservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.iir.billingservice.model.Customer;
import org.iir.billingservice.model.Product;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class ProductItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    @ManyToOne()
    private Bill bill;
    private int quantity;
    private double price;
    private double discount;
    @Transient
    private Customer customer;
    @Transient
    private Product product;

}
