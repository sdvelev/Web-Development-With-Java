package com.fmi;

public class FindFirstOccurrence {

    public static int findFirstOccurrenceOfElement(int [] number, int toFind) {

        for (int i = 0; i < number.length; i++) {
            if (number[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int [] arr = {1, 645, 45};
        int elementToFind = 645;
        System.out.println(findFirstOccurrenceOfElement(arr, elementToFind));
    }

}
