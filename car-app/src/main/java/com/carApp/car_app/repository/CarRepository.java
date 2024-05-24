package com.carApp.car_app.repository;



import com.carApp.car_app.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}