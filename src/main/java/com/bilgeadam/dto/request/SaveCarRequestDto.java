package com.bilgeadam.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaveCarRequestDto {
    @NotNull
    String carname;
    Long modelYear;
    Long dailyPrice;
    String description;
    List<Long> colorid;
    Long brandid;

}
