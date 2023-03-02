package com.fmi;

public class Pattern {

    public static String drawPattern(char element, int rows) {

        StringBuilder pattern = new StringBuilder();

        for (int i = 1; i <= rows; i++) {

            for (int j = 0; j < i; j++) {

                pattern.append(element);
            }
            pattern.append(System.lineSeparator());
        }

        return pattern.toString();
    }

    public static void main(String[] args) {

        System.out.println(drawPattern('*', 14));
    }
}
