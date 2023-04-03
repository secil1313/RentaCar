package com.bilgeadam.controller;

import com.bilgeadam.dto.request.SaveCarRequestDto;
import com.bilgeadam.entity.Car;
import com.bilgeadam.entity.JoinEntities.CarColorBrand;
import com.bilgeadam.entity.JoinEntities.CarDailyPrice;
import com.bilgeadam.entity.JoinEntities.DateNameBrandCompany;
import com.bilgeadam.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import static com.bilgeadam.constants.EndPointList.*;

@RestController
@RequestMapping(CAR)
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;
    @PostMapping(SAVE)
    public ResponseEntity<Car> saveKitap(@RequestBody @Valid SaveCarRequestDto dto){
        return ResponseEntity.ok(carService.save(dto));
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Car>> findAll(){
        List<Car> result=carService.findAll();
        return ResponseEntity.ok(result);
    }
    @GetMapping(STARTING_WITH+"/{name}")
    public ResponseEntity<List<Car>> findAllByNameStartingWithIgnoreCase(@PathVariable String name){
     return  ResponseEntity.ok(carService.findAllByNameStartingWithIgnoreCase(name));

    }
    @GetMapping(FIND_ALL_BY_BRANDID+"/{id}")
    public ResponseEntity<List<Car>> findAllByBrandid(@PathVariable Long id){
        return ResponseEntity.ok(carService.findAllByBrandid(id));
    }
    @GetMapping(FIND_ALL_BY_COLORID+"/{id}")
    public ResponseEntity<List<Car>> findAllByColorid(@PathVariable Long id){
        return ResponseEntity.ok(carService.findAllByColorid(id));
    }
    @GetMapping(FIND_CARS_COLOR_BRAND)
    public ResponseEntity<List<CarColorBrand>> findCarsWithColorAndBrand(){
        return ResponseEntity.ok(carService.findCarsWithColorAndBrand());
    }
    @GetMapping(FIND_DAILYPRICE_LESSTHAN+"/{price}")
    public ResponseEntity<List<Car>> findAllByDailyPriceLessThanEqual(@PathVariable Long price){
        return ResponseEntity.ok(carService.findAllByDailyPriceLessThanEqual(price));
    }
    @GetMapping(FIND_CAR_DAILY_PRICE)
    public ResponseEntity<List<CarDailyPrice>> findCarAndDailyPrice(){
        return ResponseEntity.ok(carService.findCarAndDailyPrice());
    }
    @GetMapping(FIND_DATE_NAME_BRAND_COMPANY)
    public ResponseEntity<List<DateNameBrandCompany>> findDateNameBrandCompany() {
        return ResponseEntity.ok(carService.findDateNameBrandCompany());
    }
}
