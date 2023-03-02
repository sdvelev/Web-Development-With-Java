package com.fmi;

public class Car {

    private String brand;
    private String model;
    private int horsePower;
    private int year;

    public Car(String brand, String model, int horsePower, int year) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
        this.year = year;
    }

    public int insuranceCategory() {

        int years = 2023 - year;

        if (years >= 26) {
            return 4;
        } else if (years >= 16) {
            return 3;
        } else if (years >= 8) {
            return 2;
        } else {
            return 1;
        }
    }

    public double insuranceValue() {

        double result = 0;

        int category = insuranceCategory();

        switch (category) {
            case 1 -> result = 150;
            case 2 -> result = 200;
            case 3 -> result = 300;
            case 4 -> result = 500;
        }

        if (horsePower < 80) {
            return result * 1.2;
        }

        if (horsePower > 140) {
            return result * 1.45;
        }

        return result;
    }

    public static void main(String[] args) {
        Car a = new Car("Lada", "5", 75, 1989);
        System.out.println(a.insuranceValue());

        Car b = new Car("Mercedes-Benz", "S220 ", 160, 2009);
        System.out.println(b.insuranceValue());
    }
}
