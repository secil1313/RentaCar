package com.bilgeadam.repository.JoinRepositories;

import com.bilgeadam.entity.JoinEntities.CarColorBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ICarColorBrandRepository extends JpaRepository<CarColorBrand,Long> {
    //Arabaları, renkleri ve markaları ile listeleyiniz.
    @Query(value = "select color.colorid,car.carname ,color.colorname as carcolorname,brand.brandname  from tblcar as car\n" +
            "inner join tblcarcolor as cc on cc.carid=car.carid\n" +
            "inner join tblcolor as color on color.colorid=cc.colorid\n" +
            "inner join tblbrand as brand on brand.brandid=car.brandid",nativeQuery = true)
    List<CarColorBrand> findCarsColorAndBrand();
}
