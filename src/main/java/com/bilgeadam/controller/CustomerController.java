package com.bilgeadam.controller;

import com.bilgeadam.dto.request.SaveCustomerRequestDto;
import com.bilgeadam.entity.Customer;
import com.bilgeadam.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import static com.bilgeadam.constants.EndPointList.*;
@RestController
@RequestMapping(CUSTOMER)
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    @PostMapping(SAVE)
    public ResponseEntity<Customer> saveCustomer(@RequestBody @Valid SaveCustomerRequestDto dto){
        return ResponseEntity.ok(customerService.save(dto));
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Customer>> findAll(){
        List<Customer> result=customerService.findAll();
        return ResponseEntity.ok(result);
    }
}
