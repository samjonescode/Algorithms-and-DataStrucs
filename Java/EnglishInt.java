import java.util.HashMap;
import java.util.Map;

public class EnglishInt {

    public static void main(String[] args) {
        System.out.println(findEnglishInt(10000));
        System.out.println(findEnglishInt(10002));
        System.out.println(findEnglishInt(100100));
        System.out.println(findEnglishInt(100127));
        System.out.println(findEnglishInt(1020020));
        System.out.println(findEnglishInt(1000000000));
        System.out.println(findEnglishInt(1823954599));
    }

    static String findEnglishInt(Integer inputNumber) {
        String inputNumAsString = inputNumber.toString();
        int downwardCounter = inputNumAsString.length();
        Map<Integer, String> boundaryWords = getBoundaryWords();
        Map<Integer, String> onesMap = getOnesMap();
        Map<Integer, String> tensMap = getTensMap();
        StringBuilder englishInt = new StringBuilder();

        for (int i = 0; i < inputNumAsString.length(); i++) {
            StringBuilder nextWord = new StringBuilder();
            int placeHelper = (downwardCounter) % 3;
            Character currChar = inputNumAsString.charAt(i);
            if (currChar.equals('0')) {
                if (downwardCounter >= 3 && (downwardCounter - 1) % 3 == 0) {
                    Integer quotient = (downwardCounter - 1) / 3;
                    if (quotient > 6) {
                        return "Number is too large!";
                    }
                    String boundaryString = boundaryWords.get(quotient);
                    nextWord = new StringBuilder(boundaryString);
                    nextWord.append(", ");
                    englishInt.append(nextWord);
                }
                downwardCounter--;
                continue;
            }

            if (placeHelper == 0) {
                // hundreds place
                Integer currCharAsInt = Integer.parseInt(currChar.toString());
                nextWord.append(onesMap.get(currCharAsInt));
                nextWord.append(" ");
                nextWord.append("hundred");

            } else if (placeHelper == 1) {
                Integer currCharAsInt = Integer.parseInt(currChar.toString());
                String nextNumAsString = onesMap.get(currCharAsInt);

                nextWord.append(nextNumAsString);
            } else if (placeHelper == 2) {
                Integer currCharAsInt = Integer.parseInt(currChar.toString());
                String nextNumAsStr = tensMap.get(currCharAsInt);
                nextWord.append(nextNumAsStr);
            }

            if ((downwardCounter - 1) % 3 == 0) {
                Integer quotient = (downwardCounter - 1) / 3;
                if (quotient > 6) {
                    return "Number is too large!";
                }
                String boundaryString = boundaryWords.get(quotient);
                Integer currCharAsInt = Integer.parseInt(currChar.toString());
                String nextNumAsString = onesMap.get(currCharAsInt);
                nextWord = new StringBuilder(nextNumAsString);
                nextWord.append(" ").append(boundaryString).append(" ").append(",");
            }
            if (nextWord != null)
                englishInt.append(nextWord).append(" ");
            downwardCounter--;
        }
        return englishInt.toString();
    }

    static Map<Integer, String> getBoundaryWords() {
        Map<Integer, String> boundaryWords = new HashMap<>();

        boundaryWords.put(6, "quintillion");
        boundaryWords.put(5, "quadrillion");
        boundaryWords.put(4, "trillion");
        boundaryWords.put(3, "billion");
        boundaryWords.put(2, "million");
        boundaryWords.put(1, "thousand");
        return boundaryWords;
    }

    static Map<Integer, String> getOnesMap() {
        Map<Integer, String> onesMap = new HashMap<>();
        onesMap.put(1, "one");
        onesMap.put(2, "two");
        onesMap.put(3, "three");
        onesMap.put(4, "four");
        onesMap.put(5, "five");
        onesMap.put(6, "six");
        onesMap.put(7, "seven");
        onesMap.put(8, "eight");
        onesMap.put(9, "nine");
        return onesMap;
    }

    static Map<Integer, String> getTensMap() {
        Map<Integer, String> tensMap = new HashMap<>();
        tensMap.put(1, "ten");
        tensMap.put(2, "twenty");
        tensMap.put(3, "thirty");
        tensMap.put(4, "forty");
        tensMap.put(5, "fifty");
        tensMap.put(6, "sixty");
        tensMap.put(7, "seventy");
        tensMap.put(8, "eighty");
        tensMap.put(9, "ninety");
        return tensMap;
    }
}