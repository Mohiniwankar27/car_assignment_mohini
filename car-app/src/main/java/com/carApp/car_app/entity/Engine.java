package com.carApp.car_app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Engine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private int horsepower;
    private String fuelType;

    // Parameterized constructor
    public Engine(String type, int horsepower, String fuelType) {
        this.type = type;
        this.horsepower = horsepower;
        this.fuelType = fuelType;
    }

    // Default constructor
    public Engine(){
        this.type = "Unknown Type";
        this.horsepower= 0;
        this.fuelType ="Unknown Type";
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
}
