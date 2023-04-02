package com.bilgeadam.repository.JoinRepositories;

import com.bilgeadam.entity.JoinEntities.DateNameBrandCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDateNameBrandCompany extends JpaRepository<DateNameBrandCompany,Long> {
//Kiralanan arabaların kiralama tarihini, araç adını, markasını ve kiralayan müşterinin firma adını listeleyiniz.
@Query(value="select r.rentalid,r.rent_date, car.carname, b.brandname, cu.company_name from tblcar as car\n" +
        "        inner join tblrental as r on r.carid=car.carid\n" +
        "\t\tinner join tblcustomer as cu on cu.customerid=r.customerid\n" +
        "\t\tinner join tblbrand as b on b.brandid=car.brandid",nativeQuery = true)
List<DateNameBrandCompany> findDateNameBrandCompany();
}
