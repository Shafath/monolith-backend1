package com.example.monolithbackend1.service;

import com.example.monolithbackend1.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer customers);
    List<Customer> getCustomers();
    Customer getCustomerById(Long customerId);

    Customer updateCustomer(Customer customer, Long customerId);

    void deleteCustomer(Long customerId);
}
