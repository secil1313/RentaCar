package com.bilgeadam.repository;

import com.bilgeadam.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICarRepository extends JpaRepository<Car,Long> {
//Kullanıcının girdiği kelimeye göre araçları bulan bir metot yazınız.
    List<Car> findAllByCarnameStartingWithIgnoreCase(String name);
    //Markaya göre arabaları getiren bir metot yazınız(brand id ile sorgulama yapabilirsiniz)
    List<Car> findAllByBrandid(Long id);
    //Aynı renkteki arabaları listeleyiniz(color id ile sorgulama yapabilirsiniz)
    @Query(value = "SELECT * FROM tblcar as car\n" +
            "inner join tblcarcolor as cc on cc.carid=car.id\n" +
            "inner join tblcolor as color on color.id=cc.colorid\n" +
            "where colorid=?1",nativeQuery = true)
    List<Car> findAllByColorid(Long colorid);
//Günlük kira ücreti belirli bir fiyatın altında olan arabaları listeleyiniz
    List<Car> findAllByDailyPriceLessThanEqual(Long price);





}
