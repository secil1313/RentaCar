package com.bilgeadam.controller;

import com.bilgeadam.dto.request.SaveBrandRequestDto;
import com.bilgeadam.entity.Brand;
import com.bilgeadam.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.bilgeadam.constants.EndPointList.*;

@RestController
@RequestMapping(BRAND)
@RequiredArgsConstructor
public class BrandController {
    private final BrandService brandService;
    @PostMapping(SAVE)
    public ResponseEntity<Brand> saveBrand( SaveBrandRequestDto dto){
        return ResponseEntity.ok(brandService.save(dto));
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Brand>> findAll(){
        List<Brand> result=brandService.findAll();
        return ResponseEntity.ok(result);
    }
}
