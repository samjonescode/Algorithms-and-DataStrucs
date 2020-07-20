package Java;

import java.util.*;

public class SearchSuggestions {

    public static void main(String[] args) {
        String[] p = new String[] { "monkey", "money", "momm", "mourning" };
        System.out.println(suggestedProducts(p, "mon"));
    }

    final static int MAX_SUGGS = 3;

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> allMatches = new ArrayList<>();
        Arrays.sort(products);
        StringBuilder prefix = new StringBuilder();
        for (char c : searchWord.toCharArray()) {
            prefix.append(c);
            List<String> currMatches = getSuggestions(prefix, products);
            allMatches.add(currMatches);
        }
        return allMatches;
    }

    // get suggestions for each new letter typed
    public static List<String> getSuggestions(StringBuilder prefix, String[] products) {
        List<String> currentSuggs = new ArrayList<>();
        int currNumProducts = 0;
        for (String p : products) {
            if (currNumProducts == MAX_SUGGS)
                break;
            if (p.startsWith(prefix.toString())) {
                currentSuggs.add(p);
                currNumProducts++;
            }

        }

        return currentSuggs;
    }
}