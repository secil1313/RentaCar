package com.bilgeadam.service;

import com.bilgeadam.dto.request.SaveCustomerRequestDto;
import com.bilgeadam.entity.Customer;
import com.bilgeadam.exception.ErrorType;
import com.bilgeadam.exception.RentaCarException;
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
            throw new RentaCarException(ErrorType.CAR_NOT_FOUND);
        }
        return customers;
    }
}
