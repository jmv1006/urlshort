package com.github.jmv1006.urlshort.urlservice;

import java.util.ArrayList;
import java.util.Random;

public class URLService {
    private final char[] characters = new char[62];

    public URLService() {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] nums = "0123456789".toCharArray();

        int index = 0;

        for(char letter : alphabet) {
            characters[index] = letter;
            index += 1;
        }

        for(char letter : alphabetUpper) {
            characters[index] = letter;
            index += 1;
        }

        for(char num : nums) {
            characters[index] = num;
            index += 1;
        }
    }

    public String encode() {
        // Creating random path
        Random rand = new Random();
        int randomInt = rand.nextInt(62, 10000);

        ArrayList<Integer> digits = new ArrayList<>();

        while (randomInt > 0) {
            float remainder = randomInt % 62;
            digits.add((int) remainder);
            randomInt = randomInt / 62;
        }

        StringBuilder mapping = new StringBuilder();

        for(Integer digit : digits) {
            char randomChar = characters[digit];
            mapping.append(randomChar);
        }

        return mapping.toString();
    }
}
