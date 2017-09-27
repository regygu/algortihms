package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MySolution implements Solution {

    @Override
    public String reverseString(String word) {
        char[] charArray = word.toCharArray();
        int lastIndex = charArray.length -1;
        String result = "";

        for (int i = lastIndex; i > -1; i--) {
            result += charArray[i];
        }

        return result;
    }

    @Override
    public long factorialize(int number) {

        int result = 1;

        if (number == 0) {
            return result;
        } else {
            for (int i = number; number > 1; number--) {
                result *= number;
            }
            return result;
        }
    }

    @Override
    public boolean palindrome(String word) {

        String simplified = word.toLowerCase().replaceAll("[^A-Za-z0-9]", "");
        //String reversedSimplified = new StringBuilder(simplified).reverse().toString();
        String reversedSimplified = reverseString(simplified);
        return simplified.equals(reversedSimplified);
    }

    @Override
    public int findLongestWord(String string) {

        int longestLength = 0;
        String[] splitString = string.split(" ");
        for (String word: splitString) {
            if (word.length() > longestLength) {
                longestLength = word.length();
            } else {
                continue;
            }
        }
        return longestLength;
    }

    @Override
    public String titleCase(String string) {

        String result = "";
        String[] splitString = string.toLowerCase().split(" ");
        for (String word: splitString) {
            result += Character.toUpperCase(word.charAt(0));
            result += word.substring(1);
            result += " ";
        }
        return result.trim();
    }

    @Override
    public int[] largestOfFour(int[][] numbers) {

        int[] result = new int[4];
        int reference = 0;
        int counter = 0;
        for (int[] subArray: numbers) {
            for (int element: subArray) {
                if (element > reference) {
                    reference = element;
                } else {
                    continue;
                }
            }
            result[counter] = reference;
            counter++;
            reference = 0;
        }

        return result;
    }

    @Override
    public boolean confirmEnding(String word, String end) {

        int lengthOfWord = word.length();
        int lengthOfEnd = end.length();

        return end.equals(word.substring(lengthOfWord - lengthOfEnd));
    }

    @Override
    public String repeatStringNumTimes(String word, int counter) {

        String result = "";

        if (counter < 1) {
            return result;
        } else {
            for (int i = 0; i < counter; i++) {
                result += word;
            }
        }
        return result;
    }

    @Override
    public String truncateString(String word, int counter) {

        if (word.length() <= counter) {
            return word;
        } else if (counter <= 3) {
            return word.substring(0, counter) + "...";
        } else {
            String theWord = word;
            int lastWhitespace;
            while (true) {
                lastWhitespace = theWord.lastIndexOf(" ");
                theWord = theWord.substring(0, lastWhitespace);
                if (theWord.length() <= counter -3) {
                    return theWord + "...";
                }
            }
        }

    }

    @Override
    public Object[][] chunkArrayInGroups(Object[] numbers, int counter) {

        //copyofrange
        int div = numbers.length / counter;
        int remainder = numbers.length % counter;
        int lastArr = 0;
        if (remainder > 0) {lastArr = 1;}

        Object[][] result = new Object[div + lastArr][];

        for (int i = 1; i < div + 1; i++) {
            result[i-1] = Arrays.copyOfRange(numbers,  (i-1)*counter, counter *i );
        }

        if (remainder > 0) {
            result[div] = Arrays.copyOfRange(numbers, (counter*div), numbers.length);
        }
        return result;
    }

    @Override
    public Object[] slasher(Object[] numbers, int counter) {

        if (counter == 0) {
            return numbers;
        } else if (counter >= numbers.length) {
            return new Object[]{};
        } else {
            return Arrays.copyOfRange(numbers, counter, numbers.length);
        }
    }

    @Override
    public Object[] destroyer(Object[] numbers, Object... remove) {

        List<Object> result = new ArrayList<>();

        for (Object n: numbers) {
            if (Arrays.asList(remove).contains(n)) {
                continue;
            } else {
                result.add(n);
            }
        }

        Object[] resultArr = new Object[result.size()];
        return result.toArray(resultArr);
    }

    @Override
    public int getIndexToIns(Object[] numbers, float number) {
        int result = 0;
        for (Object num: numbers) {
            if ((int) num < number) {
                result++;
            }
        }
        return result;
    }

    @Override
    public String rot13(String word) {

        char[] charArray = word.toCharArray();
        String res = "";

        for (char chr: charArray) {
            int chrCode = (int) chr;

            if (!Character.isLetter(chr)) {
                res += chr;
            } else if (chrCode < 78) {
                int actual = 91 + (chrCode - 78);
                res += (char) actual;
            } else {
                res += (char) (chrCode - 13);
            }
        }
        return res;
    }
}