package com.bilgeadam.controller;

import com.bilgeadam.dto.request.SaveColorRequestDto;
import com.bilgeadam.entity.Color;
import com.bilgeadam.service.ColorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.bilgeadam.constants.EndPointList.*;
import java.util.List;

@RestController
@RequestMapping(COLOR)
@RequiredArgsConstructor
public class ColorController {
    private final ColorService colorService;
    @PostMapping(SAVE)
    public ResponseEntity<Color> saveColor(@RequestBody @Valid SaveColorRequestDto dto){
        return ResponseEntity.ok(colorService.save(dto));
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Color>> findAll(){
        List<Color> result=colorService.findAll();
        return ResponseEntity.ok(result);
    }
}
