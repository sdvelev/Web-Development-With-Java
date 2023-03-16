package com.fmi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CarRepository {

    private List<Car> carInventory;

    public CarRepository() {
        this.carInventory = new ArrayList<>();
    }

    public CarRepository(List<Car> carInventory) {
        this.carInventory = carInventory;
    }

    public void addCar(Car carToAdd) {
        this.carInventory.add(carToAdd);
    }

    public void removeCar(Car carToRemove) {
        this.carInventory.remove(carToRemove);
    }

    public List<Car> searchCars(String make, String model, int year, double price) {


        return this.carInventory.stream()
            .filter(car -> car.getMake().equals(make) &&
                car.getModel().equals(model) &&
                car.getYear() == year &&
                car.getPrice() == price)
            .collect(Collectors.toList());

       /* List<Car> toReturnList = new ArrayList<>();

        for (Car currentCar : this.carInventory) {

            boolean toAdd = true;

            if (make != null && !currentCar.getMake().equals(make)) {
                toAdd = false;
            }

            if (model != null && !currentCar.getModel().equals(model)) {
                toAdd = false;
            }

            if (currentCar.getYear() != year) {
                toAdd = false;
            }

            if (currentCar.getPrice() != price) {
                toAdd = false;
            }

            if (toAdd) {
                toReturnList.add(currentCar);
            }
        }

        return toReturnList;*/
    }

    public List<Car> getAllCars() {

        return this.carInventory;
    }


}
