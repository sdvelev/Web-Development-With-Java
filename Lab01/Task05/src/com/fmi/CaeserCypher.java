package com.fmi;

public class CaeserCypher {

    private final static int NUMBER_OF_LETTERS = 26;
    private final static char SMALL_A = 'a';
    private final static char BIG_A = 'A';

    public static String encryptString(String word, int shift) {

        StringBuilder encryptedWord = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {

            if (!Character.isAlphabetic(word.charAt(i))) {
                encryptedWord.append(word.charAt(i));
                continue;
            }

            if (Character.isUpperCase(word.charAt(i))) {
                int number = (word.charAt(i) - BIG_A - shift) % NUMBER_OF_LETTERS;

                if (number < 0) {
                    number += NUMBER_OF_LETTERS;
                }

                encryptedWord.append((char) (number + BIG_A));
            } else {

                int number = (word.charAt(i) - SMALL_A - shift) % NUMBER_OF_LETTERS;

                if (number < 0) {
                    number += NUMBER_OF_LETTERS;
                }

                encryptedWord.append((char) (number + SMALL_A));
            }
        }

        return encryptedWord.toString();
    }

    public static void main(String[] args) {

        String word = "the QUICK BROWN FOX JUMPS OVER THE LAZY DOG";

        System.out.println(encryptString(word,3));
    }

}
