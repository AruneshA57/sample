package com.example.demo.Repository;

import com.example.demo.data.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer getCustomerById(Long id);


}
