package com.bilgeadam.service;

import com.bilgeadam.dto.request.SaveRentalRequestDto;
import com.bilgeadam.entity.Rental;
import com.bilgeadam.exception.ErrorType;
import com.bilgeadam.exception.RentaCarException;
import com.bilgeadam.mapper.IRentalMapper;
import com.bilgeadam.repository.IRentalRepositry;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService extends ServiceManager<Rental,Long> {

    private final IRentalRepositry rentalRepository;
    public RentalService(IRentalRepositry rentalRepository){
        super(rentalRepository);
        this.rentalRepository=rentalRepository;
    }
    public Rental save(SaveRentalRequestDto dto){
        Rental rental=save(IRentalMapper.INSTANCE.toRental(dto));
        return rental;
    }
    public List<Rental> findAll() {
        List<Rental> rentals=rentalRepository.findAll();
        if(rentals.isEmpty()){
            throw new RentaCarException(ErrorType.CAR_NOT_FOUND);
        }
        return rentals;
    }
}
