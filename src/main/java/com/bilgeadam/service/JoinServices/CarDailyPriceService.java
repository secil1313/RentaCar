package com.bilgeadam.service.JoinServices;

import com.bilgeadam.entity.JoinEntities.CarDailyPrice;
import com.bilgeadam.exception.ErrorType;
import com.bilgeadam.exception.RentaCarException;
import com.bilgeadam.repository.JoinRepositories.ICarDailyPriceRepository;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarDailyPriceService extends ServiceManager<CarDailyPrice,Long> {
    private final ICarDailyPriceRepository carDailyPriceRepository;
    public CarDailyPriceService(ICarDailyPriceRepository carDailyPriceRepository) {
        super(carDailyPriceRepository);
        this.carDailyPriceRepository = carDailyPriceRepository;

    }
    public List<CarDailyPrice> findCarAndDailyPrice(){
        List<CarDailyPrice> cdp=carDailyPriceRepository.findCarAndDailyPrice();
        if(cdp.isEmpty()){
            throw new RentaCarException(ErrorType.CAR_NOT_FOUND);
        }
        return cdp;
    }
}
