package com.bilgeadam.service;

import com.bilgeadam.dto.request.SaveCarRequestDto;
import com.bilgeadam.entity.Car;
import com.bilgeadam.entity.JoinEntities.CarColorBrand;
import com.bilgeadam.entity.JoinEntities.CarDailyPrice;
import com.bilgeadam.entity.JoinEntities.DateNameBrandCompany;
import com.bilgeadam.mapper.ICarMapper;
import com.bilgeadam.repository.ICarRepository;
import com.bilgeadam.service.JoinServices.CarColorBrandService;
import com.bilgeadam.service.JoinServices.CarDailyPriceService;
import com.bilgeadam.service.JoinServices.DateNameBrandCompanyService;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarService extends ServiceManager<Car, Long> {
    private final ICarRepository carRepository;
    private final CarColorService carColorService;
    private final CarColorBrandService carColorBrandService;
    private final CarDailyPriceService carDailyPriceService;
    private final DateNameBrandCompanyService dateNameBrandCompanyService;

    public CarService(ICarRepository carRepository, CarColorService carColorService,CarColorBrandService carColorBrandService,
                      CarDailyPriceService carDailyPriceService,DateNameBrandCompanyService dateNameBrandCompanyService) {
        super(carRepository);
        this.carRepository = carRepository;
        this.carColorService = carColorService;
        this.carColorBrandService=carColorBrandService;
        this.carDailyPriceService=carDailyPriceService;
        this.dateNameBrandCompanyService=dateNameBrandCompanyService;
    }
    public Car save(SaveCarRequestDto dto) {
        Car car = save(ICarMapper.INSTANCE.toCar(dto));
//!!!!!!!!!!!!!!!!!!!!!!!!
        dto.getColorid().forEach(colorid -> {
            carColorService.save(colorid, car.getCarid());
        }
        );
        return car;
    }
    public List<Car> findAll() {
        List<Car> carlist=carRepository.findAll();
        if(carlist.isEmpty()){
            throw new NullPointerException("Liste boş");
        }
        return carlist;
    }
    public List<Car> findAllByNameStartingWithIgnoreCase(String name){
        List<Car> car=carRepository.findAllByCarnameStartingWithIgnoreCase(name);
        if(car.isEmpty()){
            throw new NullPointerException("Liste boş");
        }
        return car;
    }
    public List<Car> findAllByBrandid(Long id){
        List<Car> car=carRepository.findAllByBrandid(id);
        if(car.isEmpty()){
            throw new NullPointerException("Liste boş");
        }
        return car;
    }
    public List<Car> findAllByColorid(Long colorid){
        List<Car> car=carRepository.findAllByColorid(colorid);
        if(car.isEmpty()){
            throw new NullPointerException("Liste boş");
        }
        return car;
    }
    public List<CarColorBrand> findCarsWithColorAndBrand(){
        List<CarColorBrand> ccb=carColorBrandService.findCarsColorAndBrand();
        if(ccb.isEmpty()){
            throw new NullPointerException("Liste boş");
        }
        return ccb;
    }
    public List<Car> findAllByDailyPriceLessThanEqual(Long price){
        List <Car> car=carRepository.findAllByDailyPriceLessThanEqual(price);
        if(car.isEmpty()){
            throw new NullPointerException("Liste boş");
        }
        return car;
    }
    public List<CarDailyPrice> findCarAndDailyPrice(){
        List<CarDailyPrice> cdp=carDailyPriceService.findCarAndDailyPrice();
        if(cdp.isEmpty()){
            throw new NullPointerException("Liste boş");
        }
        return cdp;
    }
    public List<DateNameBrandCompany> findDateNameBrandCompany() {
        List<DateNameBrandCompany> dnbc=dateNameBrandCompanyService.findDateNameBrandCompany();
        if(dnbc.isEmpty()){
            throw new NullPointerException("Liste boş");
        }
        return dnbc;
    }
}
