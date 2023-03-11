package com.fmi;

public class FindNthOddElement {

    public static int findNthOddElementInArray(int [] arr, int n) {

        int counter = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] % 2 != 0) {
                if (++counter == n) {
                    return arr[i];
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arrayFirst = {1, 2, 45, 654, 345, 5445, 35};
        int[] arraySecond = {5, 3, 8, 1, 9};

        int nFirst = 4;
        int nSecond = 5;

        System.out.println(findNthOddElementInArray(arrayFirst, nFirst));
        System.out.println(findNthOddElementInArray(arraySecond, nSecond));
    }
}
