package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.SaveBrandRequestDto;
import com.bilgeadam.dto.request.SaveCustomerRequestDto;
import com.bilgeadam.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")

public interface ICustomerMapper {
   ICustomerMapper INSTANCE= Mappers.getMapper(ICustomerMapper.class);
   Customer toCustomer(final SaveCustomerRequestDto dto);
}
