package com.vaish.practice.leetcode;

public class Task_3330 {
    public static int possibleStringCount(String word) {
        int total = 1; // original string is always valid
        int i = 0;

        while (i < word.length()) {
            char currentChar = word.charAt(i);
            int count = 1;

            // Count how many times the currentChar repeats
            while (i + 1 < word.length() && word.charAt(i + 1) == currentChar) {
                i++;
                count++;
            }

            // If group size > 1, it’s a candidate for long press fix
            if (count > 1) {
                total += count - 1; // We can remove 1 to (count - 1) characters => (count - 1) options
            }

            i++; // Move to the next character
        }

        return total;
    }
}
