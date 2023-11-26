package javaPs;

import java.util.ArrayList;
import java.util.List;

public class Strings {

    public static void main(String[] args) {
        String words = " Hello ahmed hamdy";
        System.out.println(reverseString(words));
        String input = "ABC";

        List<String> permutations = generatePermutations(input);
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }

    public static String reverseString(String str) {
        String[] reversedStrings = str.split(" ");
        for (int i = 0; i < reversedStrings.length / 2; i++) {
            String temp = reversedStrings[i];
            reversedStrings[i] = reversedStrings[reversedStrings.length - 1 - i];
            reversedStrings[reversedStrings.length - 1 - i] = temp;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : reversedStrings) {
            stringBuilder.append(word);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }

    /**
     *
     *
     */
    public static List<String> generatePermutations(String input) {
        List<String> permutations = new ArrayList<>();
        generatePermutationsHelper("", input, permutations);
        return permutations;
    }

    private static void generatePermutationsHelper(String prefix, String remaining, List<String> permutations) {
        int n = remaining.length();
        if (n == 0) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                generatePermutationsHelper(
                        prefix + remaining.charAt(i),
                        remaining.substring(0, i) + remaining.substring(i + 1, n),
                        permutations
                );
            }
        }
    }
}
