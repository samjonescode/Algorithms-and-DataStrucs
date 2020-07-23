package Java.InterviewCake;

import java.util.*;

public class WordCloud {
    public static void main(String[] args) {
        WordCloud wc = new WordCloud("I want to work at GOOGLE!!!");
        String s1 = "I want to work on interesting... and impactful technical projects of Google's.";
        WordCloud wc2 = new WordCloud(s1);
        System.out.println(wc.getWordsToCounts());
        System.out.println(wc2.getWordsToCounts());

    }

    private Map<String, Integer> wordsToCounts = new HashMap<>();

    public WordCloud(String inputString) {
        populateWordsToCounts(inputString);
    }

    public Map<String, Integer> getWordsToCounts() {
        return wordsToCounts;
    }

    private void populateWordsToCounts(String inputString) {
        // examines each letter in the input string
        // splits the string across words and passes them into addWordTohashMap

        int currentWordStartIndex = 0;
        int currentWordLength = 0;

        for (int i = 0; i < inputString.length(); i++) {
            char character = inputString.charAt(i);

            // after reaching the end of the string
            // check whether the last character is a letter, and add the last word
            // to the map
            if (i == inputString.length() - 1) {
                if (Character.isLetter(character)) {
                    currentWordLength++;
                }
                if (currentWordLength > 0) {
                    String currentWord = inputString.substring(currentWordStartIndex,
                            currentWordStartIndex + currentWordLength);
                    addWordToHashMap(currentWord);
                }
                // If we're at a space or emdash (\u2014), then we've completed a word.
                // Add the word to the map and reset the currentWordLength.
            } else if (character == ' ' || character == '\u2014') {
                if (currentWordLength > 0) {
                    String currentWord = inputString.substring(currentWordStartIndex,
                            currentWordStartIndex + currentWordLength);
                    addWordToHashMap(currentWord);
                    currentWordLength = 0;
                }
                // if the character is part of an ellipses, we're at the end of a word.
                // don't include the periods !
                // shave them off and add the preceding word to the map
            } else if (character == '.') {
                if (i < inputString.length() - 1 & inputString.charAt(i + 1) == '.') {
                    if (currentWordLength > 0) {
                        String currentWord = inputString.substring(currentWordStartIndex,
                                currentWordStartIndex + currentWordLength);
                        addWordToHashMap(currentWord);
                        currentWordLength = 0;
                    }
                }
                // if the character is a letter, or an apostrophe,
                // We're in the middle of a word, so keep iterating over characters.
            } else if (Character.isLetter(character) || character == '\'') {
                if (currentWordLength == 0) {
                    currentWordStartIndex = i;
                }

                currentWordLength++;

                // if character is a hyphen, it could be part of a hyphenated word.
                // if it's part of a hyphenated word, then letters should surround it on either
                // side.
                // that word belongs in our map
            } else if (character == '-') {
                if (i > 0 & Character.isLetter(inputString.charAt(i - 1))
                        && Character.isLetter(inputString.charAt(i + 1))) {
                    if (currentWordLength == 0) {
                        currentWordStartIndex = 1;
                    }
                } else {
                    if (currentWordLength > 0) {
                        String currentWord = inputString.substring(currentWordStartIndex,
                                currentWordStartIndex + currentWordLength);
                        addWordToHashMap(currentWord);
                    }
                }
            }
        }
    }

    public void addWordToHashMap(String word) {
        if (wordsToCounts.containsKey(word)) {
            wordsToCounts.put(word, wordsToCounts.get(word));
        } else {
            wordsToCounts.put(word, 1);
        }
    }

}