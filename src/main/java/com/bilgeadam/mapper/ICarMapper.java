package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.SaveCarRequestDto;
import com.bilgeadam.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface ICarMapper {
    ICarMapper INSTANCE= Mappers.getMapper(ICarMapper.class);
    Car toCar(final SaveCarRequestDto dto);
}
