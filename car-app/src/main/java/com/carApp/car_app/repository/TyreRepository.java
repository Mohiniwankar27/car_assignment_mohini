package com.carApp.car_app.repository;

import com.carApp.car_app.entity.Tyre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TyreRepository extends JpaRepository<Tyre, Long> {
}