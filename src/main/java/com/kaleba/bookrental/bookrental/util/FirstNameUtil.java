package com.kaleba.bookrental.bookrental.util;

public class FirstNameUtil {
    public static String capitalizeFirstLetters(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        
        String[] words = str.split("\\s+");
        StringBuilder capitalized = new StringBuilder();
        
        for (String word : words) {
            if (word.length() > 0) {
                capitalized.append(Character.toUpperCase(word.charAt(0)))
                           .append(word.substring(1).toLowerCase())
                           .append(" ");
            }
        }
        
        // Remove the trailing space
        return capitalized.toString().trim();
    }
}
