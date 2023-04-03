package com.bilgeadam.service;

import com.bilgeadam.dto.request.SaveColorRequestDto;
import com.bilgeadam.entity.Color;
import com.bilgeadam.exception.ErrorType;
import com.bilgeadam.exception.RentaCarException;
import com.bilgeadam.mapper.IColorMapper;
import com.bilgeadam.repository.IColorRepository;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorService extends ServiceManager<Color,Long> {
    private final IColorRepository colorRepository;
    public ColorService(IColorRepository colorRepository){
        super(colorRepository);
        this.colorRepository=colorRepository;
    }
    public Color save(SaveColorRequestDto dto){
        Optional<Color> color=colorRepository.findOptionalByColornameIgnoreCase(dto.getColorname());
        if(color.isPresent()){
            throw new RentaCarException(ErrorType.COLOR_IS_EXIST);
        }
        return save(IColorMapper.INSTANCE.toColor(dto));
    }
    public List<Color> findAll() {
        List<Color> color=colorRepository.findAll();
        if(color.isEmpty()){
            throw new RentaCarException(ErrorType.NOT_FOUND_COLOR);
        }
        return color;
    }
}
