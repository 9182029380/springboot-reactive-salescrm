package com.example.SpringbootReactiveSalesCrm.repo;

import com.example.SpringbootReactiveSalesCrm.model.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {
    Flux<Customer> findByAssignedTo(String assignedTo);  // Custom query to find customers assigned to a salesperson
}

