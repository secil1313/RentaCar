package com.bilgeadam.service.JoinServices;

import com.bilgeadam.entity.JoinEntities.CarColorBrand;
import com.bilgeadam.exception.ErrorType;
import com.bilgeadam.exception.RentaCarException;
import com.bilgeadam.repository.JoinRepositories.ICarColorBrandRepository;

import com.bilgeadam.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarColorBrandService extends ServiceManager<CarColorBrand,Long> {
    private final ICarColorBrandRepository carColorBrandRepository;
    public CarColorBrandService (ICarColorBrandRepository carColorBrandRepository){
        super(carColorBrandRepository);
        this.carColorBrandRepository=carColorBrandRepository;
    }
    public List<CarColorBrand> findCarsColorAndBrand(){
        List<CarColorBrand> ccb=carColorBrandRepository.findCarsColorAndBrand();
        if(ccb.isEmpty()){
            throw new RentaCarException(ErrorType.CAR_NOT_FOUND);
        }
        return ccb;
    }
}
