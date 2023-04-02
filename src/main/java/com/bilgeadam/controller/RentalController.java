package com.bilgeadam.controller;

import com.bilgeadam.dto.request.SaveRentalRequestDto;
import com.bilgeadam.entity.Rental;
import com.bilgeadam.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.bilgeadam.constants.EndPointList.*;
@RestController
@RequestMapping(CONTROLLER)
@RequiredArgsConstructor
public class RentalController {
    private final RentalService rentalService;
    @PostMapping(RENTAL)
    public ResponseEntity<Rental> saveRental(@RequestBody SaveRentalRequestDto dto){
        return ResponseEntity.ok(rentalService.save(dto));
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Rental>> findAll(){
        List<Rental> result=rentalService.findAll();
        return ResponseEntity.ok(result);
    }
}
