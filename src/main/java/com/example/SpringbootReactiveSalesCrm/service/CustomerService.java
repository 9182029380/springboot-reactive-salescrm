package com.example.SpringbootReactiveSalesCrm.service;

import com.example.SpringbootReactiveSalesCrm.model.Customer;
import com.example.SpringbootReactiveSalesCrm.repo.CustomerRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Flux<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Mono<Customer> getCustomerById(String id) {
        return customerRepository.findById(id);
    }

    public Mono<Customer> createCustomer(Customer customer) {
        customer.setCreatedAt(LocalDateTime.now());
        customer.setUpdatedAt(LocalDateTime.now());
        return customerRepository.save(customer);
    }

    public Mono<Customer> updateCustomer(String id, Customer updatedCustomer) {
        return customerRepository.findById(id)
                .flatMap(existingCustomer -> {
                    updatedCustomer.setId(existingCustomer.getId());
                    updatedCustomer.setUpdatedAt(LocalDateTime.now());
                    return customerRepository.save(updatedCustomer);
                });
    }

    public Mono<Void> deleteCustomer(String id) {
        return customerRepository.deleteById(id);
    }

    public Flux<Customer> getCustomersByAssignedTo(String assignedTo) {
        return customerRepository.findByAssignedTo(assignedTo);
    }
}

