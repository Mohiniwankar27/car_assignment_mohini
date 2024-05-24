package com.carApp.car_app.controller;

import com.carApp.car_app.Service.CarService;
import com.carApp.car_app.entity.Car;
import com.carApp.car_app.entity.Tyre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService; // instance of CarService to interact with car data

    // Endpoint to retrieve all cars
    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    // Endpoint to retrieve a specific car by ID
    @GetMapping("/{id}")
    public Optional<Car> getCarById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    // Endpoint to create a new car
    @PostMapping
    public Car createCar(@RequestBody Car car) {
        return carService.saveCar(car);
    }

    // Endpoint to update an existing car
    @PutMapping("/{id}")
    public Car updateCar(@PathVariable Long id, @RequestBody Car carDetails) {
        return carService.updateCar(id, carDetails);
    }

    // Endpoint to delete a car by ID
    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }

    // Endpoint to retrieve details of a specific tyre of a car
    @GetMapping("/{carId}/tyres/{position}/details")
    public ResponseEntity<Tyre> getTyreDetails(@PathVariable Long carId, @PathVariable String position) {
        Tyre tyre = carService.getTyreDetails(carId, position);
        return ResponseEntity.ok(tyre);
    }
}
