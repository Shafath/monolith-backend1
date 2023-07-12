package com.example.monolithbackend1.serviceImpl;

import com.example.monolithbackend1.exception.ResourceNotFoundException;
import com.example.monolithbackend1.model.Customer;
import com.example.monolithbackend1.repository.CustomerRepository;
import com.example.monolithbackend1.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        super();
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return this.customerRepository.save(customer);
    }

    @Override
    public List<Customer> getCustomers() {
        return this.customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        return this.customerRepository.findById(customerId).orElseThrow(() ->
            new ResourceNotFoundException("Customer", "Id", customerId)
        );
    }

    @Override
    public Customer updateCustomer(Customer customer, Long customerId) {
        Customer existingCustomer = this.customerRepository.findById(customerId).orElseThrow(() ->
                new ResourceNotFoundException("Product", "Id", customerId)
        );

        existingCustomer.setCustomerName(customer.getCustomerName());
        existingCustomer.setCustomerAddress(customer.getCustomerAddress());
        return this.customerRepository.save(existingCustomer);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        this.customerRepository.findById(customerId).orElseThrow(() ->
                new ResourceNotFoundException("Customer", "Id", customerId)
        );
        this.customerRepository.deleteById(customerId);
    }
}
