package com.carApp.car_app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tyre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private int pressure;
    private String size;
    private String position;

    // Parameterized constructor
    public Tyre(String brand, int pressure, String size, String position) {
        this.brand = brand;
        this.pressure = pressure;
        this.size = size;
        this.position = position;
    }

    // Default constructor
    public Tyre(){
        this.brand = "Unknown Brand";
        this.pressure = 0;
        this.size = "Unknown Size";
        this.position = "Unknown Position";
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
