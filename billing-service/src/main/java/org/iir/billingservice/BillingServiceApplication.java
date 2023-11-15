package org.iir.billingservice;

import org.iir.billingservice.entities.Bill;
import org.iir.billingservice.entities.ProductItem;
import org.iir.billingservice.model.Customer;
import org.iir.billingservice.model.Product;
import org.iir.billingservice.repository.BillRepository;
import org.iir.billingservice.repository.ProductItemRepository;
import org.iir.billingservice.services.CustomerRestClient;
import org.iir.billingservice.services.ProductRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(BillRepository billRepository,
							ProductItemRepository productItemRepository,
							CustomerRestClient customerRestClient,
							ProductRestClient productRestClient){
		return args -> {
			Collection<Product> products=productRestClient.allProducts().getContent();
			Long customerId=1L;
			Customer customer=customerRestClient.findCustomerById(customerId);
			if (customer==null) throw new RuntimeException("Customer not found");
			Bill bill=new Bill();
			bill.setBillDate(new Date());
			bill.setCustomerId(customerId);
			Bill savedBill = billRepository.save(bill);
			products.forEach(product -> {
				ProductItem productItem=new ProductItem();
				productItem.setBill(savedBill);
				productItem.setProductId(product.getId());
				productItem.setQuantity(1+new Random().nextInt(10));
				productItem.setPrice(product.getPrice());
				productItem.setDiscount(Math.random());
				productItemRepository.save(productItem);
			});
		};
	}
}
