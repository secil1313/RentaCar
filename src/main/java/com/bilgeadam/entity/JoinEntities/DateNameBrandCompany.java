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
@Table(name = "tbldatenamebrandcompany")
public class DateNameBrandCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//idyi otomatik arttırıyordu.
    @Column(name="rentalid")
    Long id;
    String carname;
    Long rentDate;
    String brandname;
    String companyName;

}
