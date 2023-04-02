package com.bilgeadam.repository;

import com.bilgeadam.entity.CarColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarColorRepository extends JpaRepository<CarColor,Long> {
}
