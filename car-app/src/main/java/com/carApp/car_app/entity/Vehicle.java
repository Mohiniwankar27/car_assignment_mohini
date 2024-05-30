package com.carApp.car_app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Vehicle")
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private int year;
    private String color;

    // Parameterized Constructors
    public Vehicle(String brand, int year, String color) {
        this.brand = brand;
        this.year = year;
        this.color = color;
    }

    public Vehicle() {
        // Default constructor
        this.brand = "Unknown Brand";
        this.year = 0;
        this.color = "Unknown Color";
    }

    // Getters and setters
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
