package com.bilgeadam.repository;

import com.bilgeadam.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IBrandRepository extends JpaRepository<Brand,Long> {
    Optional<Brand> findOptionalByBrandnameIgnoreCase(String name);
}
