package com.example.demo.Service;

import com.example.demo.Repository.AddressRepository;
import com.example.demo.Repository.CustomerRepository;
import com.example.demo.data.model.Address;
import com.example.demo.data.model.Customer;
import com.example.demo.dto.NewCustomer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
public class CustomerService {

    private final AddressRepository addressRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(AddressRepository addressRepository,
                           CustomerRepository customerRepository) {
        this.addressRepository = addressRepository;
        this.customerRepository = customerRepository;
    }

    @Transactional
    public Customer createNewCustomer(NewCustomer newCustomer){
        Customer customer = new Customer(newCustomer);
        log.info(newCustomer.toString());

        Address address = new Address(newCustomer);
        addressRepository.save(address);
        customer.setAddress(address);
        customer = customerRepository.save(customer);
        customer.setCustomerId("CUST000" + customer.getId().toString());
        return customerRepository.save(customer);
    }

    @Transactional
    public Customer getCustomer(Long cusId){
        Customer customer = customerRepository.getCustomerById(cusId);
        return customer;

    }


}
