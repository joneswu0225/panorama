package com.jones.panorama.util;

import java.util.Random;

/**
 * Created by jones on 18-3-9.
 */
public class RandomString {
    public static final String SOURCES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    public static void main(String[] args) {
        System.out.println(RandomString.generate(5));
    }

    public static String generate(int size){
        return generateString(new Random(), SOURCES, size);
    }
    /**
     * Generate a random string.
     * @param random the random number generator.
     * @param characters the characters for generating string.
     * @param length the length of the generated string.
     * @return
     */
    private static String generateString(Random random, String characters, int length) {
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(random.nextInt(characters.length()));
        }
        return new String(text);
    }
}
