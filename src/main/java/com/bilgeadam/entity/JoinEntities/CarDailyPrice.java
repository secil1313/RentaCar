package com.bilgeadam.entity.JoinEntities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_cardailyprice")
public class CarDailyPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//idyi otomatik arttırıyordu.
@Column(name="rentalid")//En genel olanın ıdsını buraya yaz.
    Long id;
    String carname;
    Long dailyPrice;
}
