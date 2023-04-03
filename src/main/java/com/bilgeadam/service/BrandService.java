package com.bilgeadam.service;

import com.bilgeadam.dto.request.SaveBrandRequestDto;
import com.bilgeadam.entity.Brand;
import com.bilgeadam.exception.ErrorType;
import com.bilgeadam.exception.RentaCarException;
import com.bilgeadam.mapper.IBrandMapper;
import com.bilgeadam.repository.IBrandRepository;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BrandService extends ServiceManager<Brand,Long> {
    private final IBrandRepository brandRepository;
    public BrandService (IBrandRepository brandRepository){
        super(brandRepository);
        this.brandRepository=brandRepository;
    }
    public Brand save(SaveBrandRequestDto dto){
        Optional<Brand> brand=brandRepository.findOptionalByBrandnameIgnoreCase(dto.getBrandname());
        if(brand.isPresent()){
            throw new RentaCarException(ErrorType.BRAND_IS_EXIST);
        }
        return save(IBrandMapper.INSTANCE.toBrand(dto));
    }
    public List<Brand> findAll() {
        List<Brand> brand=brandRepository.findAll();
        if(brand.isEmpty()){
            throw new RentaCarException(ErrorType.CAR_NOT_FOUND);
        }
        return brand;
    }
}
