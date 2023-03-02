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

        int arr[] = {1, 2, 45, 654, 345, 5445, 35};

        int n = 4;

        System.out.println(findNthOddElementInArray(arr, n));
    }
}
