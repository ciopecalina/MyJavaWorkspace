package recap_exercises.strings.ex1a;

import java.util.Scanner;

public class Main {
    private static void printCharWithMaxFrequency(String s) {
        s = s.toLowerCase();
        int maxFreq = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isWhitespace(s.charAt(i))) {
                continue;
            }

            int charFreq = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    charFreq++;
                }
            }
            maxFreq = charFreq > maxFreq ? charFreq : maxFreq;

        }

        for (int i = 0; i < s.length(); i++) {
            if (Character.isWhitespace(s.charAt(i))) {
                continue;
            }

            int charFreq = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    charFreq++;
                }
            }
            if (charFreq == maxFreq) {
                System.out.println("Character '" + s.charAt(i) + "' appears " + maxFreq + " times.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        printCharWithMaxFrequency(s);
    }
}

