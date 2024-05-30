
package com.carApp.car_app.entity;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Car")
public class Car extends Vehicle {
    private String model;

    // One-to-one relationship with Engine entity
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "engine_id", referencedColumnName = "id")
    private Engine engine;

    // One-to-many relationship with Tyre entity
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id")
    private List<Tyre> tyres;

    //  Parameterized Constructors
    public Car(String model, String brand, int year, String color, Engine engine, List<Tyre> tyres) {
        super(brand, year, color);
        this.model = model;
        this.engine = engine;
        this.tyres = tyres;
    }

    // Default constructor
    public Car() {
        super("Unknown Brand", 0, "Unknown Color");
        this.model = "Unknown Model";
        this.engine = null;
        this.tyres = new ArrayList<>();
    }

    // Getters and setters
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public List<Tyre> getTyres() {
        return tyres;
    }

    public void setTyres(List<Tyre> tyres) {
        this.tyres = tyres;
    }
}
