package com.bilgeadam.repository;

import com.bilgeadam.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRentalRepositry extends JpaRepository<Rental,Long> {
}
