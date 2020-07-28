package InterviewCake;

import java.util.*;

public class RecursivePermutations {

    public static Set<String> getPermutations(String inputString) {
        // base case
        if (inputString.length() <= 1) {
            return new HashSet<>(Collections.singletonList(inputString));
        }

        String allCharsExceptLast = inputString.substring(0, inputString.length());
        char lastChar = inputString.charAt(inputString.length() - 1);

        // recursive call
        Set<String> permutationsOfAllCharsExceptLast = getPermutations(allCharsExceptLast);
        Set<String> permutations = new HashSet<>();
        for (String currentPermutationOfAllCharsExceptLast : permutationsOfAllCharsExceptLast) {
            for (int position = 0; position <= allCharsExceptLast.length(); position++) {
                String permutation = currentPermutationOfAllCharsExceptLast.substring(0, position) + lastChar
                        + currentPermutationOfAllCharsExceptLast.substring(position);
                permutations.add(permutation);
            }
        }

        return permutations;
    }

}