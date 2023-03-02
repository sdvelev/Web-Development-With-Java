package com.fmi;

public class CaeserCypher {

    public static String encryptString(String word, int shift) {

        StringBuilder encryptedWord = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {

            int number = (word.charAt(i) - 'a' - shift) % 26;

            encryptedWord.append((char) (number + 'a'));
        }

        return encryptedWord.toString();
    }

    public static void main(String[] args) {

        String word = "the";
        System.out.println(encryptString(word,3));
    }

}
