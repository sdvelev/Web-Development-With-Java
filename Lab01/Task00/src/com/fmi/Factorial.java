package com.fmi;

public class Factorial {

    public static int calculateFactorial(int number) {

        if (number < 0) {
            return -1;
        }

        if (number == 0) {
            return 1;
        }

        return number * calculateFactorial(number - 1);
    }

    public static void main(String[] args) {

        System.out.println(calculateFactorial(4));
    }

}
