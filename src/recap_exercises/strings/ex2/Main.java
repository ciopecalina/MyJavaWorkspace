package recap_exercises.strings.ex2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static String deleteAllNonLetterChars(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            if (!Character.isLetter(sb.charAt(i))) {
                sb.deleteCharAt(i);
                i--;
            }
        }
        return sb.toString();
    }

    private static boolean anagramSolver(String anag1, String anag2) {
        String anag1OnlyLetters = deleteAllNonLetterChars(anag1);
        String anag2OnlyLetters = deleteAllNonLetterChars(anag2);

        anag1OnlyLetters = anag1OnlyLetters.toLowerCase();
        anag2OnlyLetters = anag2OnlyLetters.toLowerCase();

        char[] anag1Array = anag1OnlyLetters.toCharArray();
        char[] anag2Array = anag2OnlyLetters.toCharArray();

        Arrays.sort(anag1Array);
        Arrays.sort(anag2Array);

        return Arrays.equals(anag1Array, anag2Array);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        System.out.println(anagramSolver(s1, s2));
    }
}

