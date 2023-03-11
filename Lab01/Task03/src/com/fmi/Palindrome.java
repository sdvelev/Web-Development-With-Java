package com.fmi;

public class Palindrome {

    public static boolean isPalindrome(String toCheck) {

        for (int i = 0; i < toCheck.length() / 2; i++) {

            if (toCheck.charAt(i) != toCheck.charAt(toCheck.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(isPalindrome("abcba"));
        System.out.println(isPalindrome("ab"));
        System.out.println(isPalindrome("a"));
        System.out.println(isPalindrome("abba"));
        System.out.println(isPalindrome(""));
    }
}

