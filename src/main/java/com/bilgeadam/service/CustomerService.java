package com.bilgeadam.service;

import com.bilgeadam.dto.request.SaveCustomerRequestDto;
import com.bilgeadam.entity.Customer;
import com.bilgeadam.mapper.ICustomerMapper;
import com.bilgeadam.repository.ICustomerRepository;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService extends ServiceManager<Customer,Long> {
    private final ICustomerRepository customerRepository;
    public CustomerService(ICustomerRepository customerRepository){
        super(customerRepository);
        this.customerRepository=customerRepository;
    }
    public Customer save(SaveCustomerRequestDto dto){
        Customer customer=save(ICustomerMapper.INSTANCE.toCustomer(dto));
        return customer;
    }
    public List<Customer> findAll() {
        List<Customer> customers=customerRepository.findAll();
        if(customers.isEmpty()){
            throw new NullPointerException("Liste boş");
        }
        return customers;
    }
}
