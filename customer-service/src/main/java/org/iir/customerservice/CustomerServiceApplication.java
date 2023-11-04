package org.iir.customerservice;

import org.iir.customerservice.entities.Customer;
import org.iir.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(CustomerRepository customerRepository,
                                               RepositoryRestConfiguration repositoryRestConfiguration){
        return args -> {
        repositoryRestConfiguration.exposeIdsFor(Customer.class);
        customerRepository.saveAll(
                List.of(
                        Customer.builder().name("hiba").email("hiba@gmail.com").build(),
                        Customer.builder().name("mohamed").email("mohamed@gmail.com").build(),
                        Customer.builder().name("kenza").email("kenza@gmail.com").build()
                        )
        );
        customerRepository.findAll().forEach(c->{
            System.out.println(c);
        });
        };
    }

}
