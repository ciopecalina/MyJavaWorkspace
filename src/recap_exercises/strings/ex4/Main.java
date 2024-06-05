package recap_exercises.strings.ex4;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static String[] selectiveFilter(String[] words, String key, int matchKey) {
        String[] result = new String[words.length];
        int index = 0;
        key = key.toLowerCase();
        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();
            int minLength = Math.min(key.length(), word.length());
            int countMatches = 0;
            for (int j = 0; j < minLength; j++) {
                if (word.charAt(j) == key.charAt(j)) {
                    countMatches++;
                }
            }

            if (countMatches >= matchKey) {
                result[index] = words[i];
                index++;
            }
        }
        return Arrays.copyOf(result, index);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; ++i) {
            words[i] = scanner.next();
        }

        String key = scanner.next();
        int matchKey = scanner.nextInt();

        String[] matchedWords = selectiveFilter(words, key, matchKey);
        for (int i = 0; i < matchedWords.length; ++i) {
            System.out.print(matchedWords[i] + " ");
        }
    }
}

