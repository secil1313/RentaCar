package com.bilgeadam.service;

import com.bilgeadam.entity.CarColor;
import com.bilgeadam.repository.ICarColorRepository;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class CarColorService extends ServiceManager<CarColor,Long> {
    private final ICarColorRepository carColorRepository;
    public CarColorService (ICarColorRepository carColorRepository){
        super(carColorRepository);
        this.carColorRepository=carColorRepository;
    }
    public void save(Long colorId,Long carId){
        save(CarColor.builder()
                .carid(carId)
                .colorid(colorId)
                .build());
    }
}
