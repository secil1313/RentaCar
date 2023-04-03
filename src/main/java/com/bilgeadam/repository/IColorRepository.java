package com.bilgeadam.repository;

import com.bilgeadam.entity.Brand;
import com.bilgeadam.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IColorRepository extends JpaRepository<Color,Long> {
    Optional<Color> findOptionalByColornameIgnoreCase(String name);
}
