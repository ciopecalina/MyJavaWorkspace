package recap_exercises.strings.ex1b;

import java.util.Scanner;

public class Main {
    private static void printCharWithMinFrequency(String s) {
        s = s.toLowerCase();

        int minFreq = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isWhitespace(s.charAt(i)) ||
                    s.indexOf(s.charAt(i)) != i) {
                continue;
            }

            int charFreq = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    charFreq++;
                }
            }
            minFreq = charFreq < minFreq ? charFreq : minFreq;
        }

        for (int i = 0; i < s.length(); i++) {
            if (Character.isWhitespace(s.charAt(i)) ||
                    s.indexOf(s.charAt(i)) != i) {
                continue;
            }

            int charFreq = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    charFreq++;
                }
            }
            if (charFreq == minFreq) {
                System.out.println("Character '" + s.charAt(i) +
                        "' appears " + minFreq + " times.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        printCharWithMinFrequency(s);
    }
}

