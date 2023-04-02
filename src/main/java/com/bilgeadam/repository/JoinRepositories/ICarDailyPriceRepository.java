package com.bilgeadam.repository.JoinRepositories;

import com.bilgeadam.entity.JoinEntities.CarDailyPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICarDailyPriceRepository extends JpaRepository<CarDailyPrice,Long> {
    //Kiralanan arabaları ve bu arabaların günlük kira ücretlerini gösteren bir metot yazınız.
@Query(value = "select r.rentalid,car.carname ,car.daily_price from tblcar as car\n" +
        "inner join tblrental as r on r.carid=car.carid",nativeQuery = true)
List<CarDailyPrice> findCarAndDailyPrice();
}
