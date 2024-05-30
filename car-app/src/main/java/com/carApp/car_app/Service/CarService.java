//package com.carApp.car_app.Service;
//
//import com.carApp.car_app.entity.Car;
//import com.carApp.car_app.entity.Engine;
//import com.carApp.car_app.entity.Tyre;
//import com.carApp.car_app.repository.CarRepository;
//import com.carApp.car_app.repository.EngineRepository;
//import com.carApp.car_app.repository.TyreRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class CarService {
//    @Autowired
//    private CarRepository carRepository;
//
//    @Autowired
//    private EngineRepository engineRepository;
//
//    @Autowired
//    private TyreRepository tyreRepository;
//
//    // Method to retrieve all cars
//    public List<Car> getAllCars() {
//        return carRepository.findAll();
//    }
//
//    // Method to retrieve a car by ID
//    public Optional<Car> getCarById(Long id) {
//        return carRepository.findById(id);
//    }
//
//    // Method to save a new car
//    public Car saveCar(Car car) {
//        // Set tyre positions
//        List<Tyre> tyres = car.getTyres();
//        for (int i = 0; i < tyres.size(); i++) {
//            switch (i) {
//                case 0:
//                    tyres.get(i).setPosition("front right");
//                    break;
//                case 1:
//                    tyres.get(i).setPosition("front left");
//                    break;
//                case 2:
//                    tyres.get(i).setPosition("back right");
//                    break;
//                case 3:
//                    tyres.get(i).setPosition("back left");
//                    break;
//                // Add more cases if needed for additional tyres
//            }
//        }
//        car.setTyres(tyres); // Set the modified tyres back to the car object
//        return carRepository.save(car);
//    }
//
//    // Method to update an existing car
//    public Car updateCar(Long id, Car carDetails) {
//        // Find the car by ID
//        Optional<Car> optionalCar = carRepository.findById(id);
//        if (optionalCar.isPresent()) {
//            Car car = optionalCar.get();
//
//            // Update car details
//            car.setBrand(carDetails.getBrand());
//            car.setModel(carDetails.getModel());
//            car.setYear(carDetails.getYear());
//            car.setColor(carDetails.getColor());
//
//            // Update engine details
//            Engine newEngineDetails = carDetails.getEngine();
//            if (newEngineDetails != null) {
//                Engine existingEngine = car.getEngine();
//                if (existingEngine == null) {
//                    existingEngine = new Engine(); // Create a new engine if it doesn't exist
//                }
//                existingEngine.setType(newEngineDetails.getType());
//                existingEngine.setHorsepower(newEngineDetails.getHorsepower());
//                existingEngine.setFuelType(newEngineDetails.getFuelType());
//                car.setEngine(existingEngine); // Set the updated engine
//            }
//
//            // Update tyre details
//            List<Tyre> newTyresDetails = carDetails.getTyres();
//            List<Tyre> existingTyres = car.getTyres();
//            for (int i = 0; i < existingTyres.size(); i++) {
//                Tyre existingTyre = existingTyres.get(i);
//                if (i < newTyresDetails.size()) {
//                    Tyre newTyreDetails = newTyresDetails.get(i);
//                    existingTyre.setBrand(newTyreDetails.getBrand());
//                    existingTyre.setPressure(newTyreDetails.getPressure());
//                    existingTyre.setSize(newTyreDetails.getSize());
//                }
//            }
//
//            // Save the updated car
//            return carRepository.save(car);
//        } else {
//            throw new RuntimeException("Car not found with id " + id);
//        }
//    }
//
//    // Method to retrieve tyre details by position for a given car ID
//    public Tyre getTyreDetails(Long carId, String position) {
//        Optional<Car> optionalCar = carRepository.findById(carId);
//        if (optionalCar.isPresent()) {
//            Car car = optionalCar.get();
//            for (Tyre tyre : car.getTyres()) {
//                if (tyre.getPosition().equalsIgnoreCase(position)) {
//                    return tyre;
//                }
//            }
//        }
//        throw new RuntimeException("Tyre not found with position " + position + " for car ID " + carId);
//    }
//
//    // Method to delete a car by ID
//    public void deleteCar(Long id) {
//        carRepository.deleteById(id);
//    }
//}

package com.carApp.car_app.Service;

import com.carApp.car_app.entity.Car;
import com.carApp.car_app.entity.Engine;
import com.carApp.car_app.entity.Tyre;
import com.carApp.car_app.repository.CarRepository;
import com.carApp.car_app.repository.EngineRepository;
import com.carApp.car_app.repository.TyreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private EngineRepository engineRepository;

    @Autowired
    private TyreRepository tyreRepository;

    // Method to retrieve all cars
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    // Method to retrieve a car by ID
    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }

    // Method to save a new car
    public Car saveCar(Car car) {
        // Set tyre positions
        List<Tyre> tyres = car.getTyres();
        for (int i = 0; i < tyres.size(); i++) {
            switch (i) {
                case 0:
                    tyres.get(i).setPosition("front right");
                    break;
                case 1:
                    tyres.get(i).setPosition("front left");
                    break;
                case 2:
                    tyres.get(i).setPosition("back right");
                    break;
                case 3:
                    tyres.get(i).setPosition("back left");
                    break;
                // Add more cases if needed for additional tyres
            }
        }
        car.setTyres(tyres); // Set the modified tyres back to the car object
        return carRepository.save(car);
    }

    // Method to update an existing car
    public Car updateCar(Long id, Car carDetails) {
        // Find the car by ID
        Optional<Car> optionalCar = carRepository.findById(id);
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();

            // Update car details
            car.setBrand(carDetails.getBrand());
            car.setModel(carDetails.getModel());
            car.setYear(carDetails.getYear());
            car.setColor(carDetails.getColor());

            // Update engine details
            Engine newEngineDetails = carDetails.getEngine();
            if (newEngineDetails != null) {
                Engine existingEngine = car.getEngine();
                if (existingEngine == null) {
                    existingEngine = new Engine(); // Create a new engine if it doesn't exist
                }
                existingEngine.setType(newEngineDetails.getType());
                existingEngine.setHorsepower(newEngineDetails.getHorsepower());
                existingEngine.setFuelType(newEngineDetails.getFuelType());
                car.setEngine(existingEngine); // Set the updated engine
            }

            // Update tyre details
            List<Tyre> newTyresDetails = carDetails.getTyres();
            List<Tyre> existingTyres = car.getTyres();
            for (int i = 0; i < existingTyres.size(); i++) {
                Tyre existingTyre = existingTyres.get(i);
                if (i < newTyresDetails.size()) {
                    Tyre newTyreDetails = newTyresDetails.get(i);
                    existingTyre.setBrand(newTyreDetails.getBrand());
                    existingTyre.setPressure(newTyreDetails.getPressure());
                    existingTyre.setSize(newTyreDetails.getSize());
                }
            }

            // Save the updated car
            return carRepository.save(car);
        } else {
            throw new RuntimeException("Car not found with id " + id);
        }
    }

    // Method to retrieve tyre details by position for a given car ID
    public Tyre getTyreDetails(Long carId, String position) {
        Optional<Car> optionalCar = carRepository.findById(carId);
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            for (Tyre tyre : car.getTyres()) {
                if (tyre.getPosition().equalsIgnoreCase(position)) {
                    return tyre;
                }
            }
        }
        throw new RuntimeException("Tyre not found with position " + position + " for car ID " + carId);
    }

    // Method to delete a car by ID
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
