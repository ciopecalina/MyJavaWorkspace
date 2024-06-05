package java_collections_arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    private static void computeMaxFreq(String str) {
        str = str.toLowerCase();
        ArrayList<Character> list = new ArrayList<>();
        int maxFreq = 0;

        for (int i = 0; i < str.length(); i++) {
            if (Character.isWhitespace(str.charAt(i))) {
                continue;
            }
            int charFreq = 1;
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    charFreq++;
                }
            }
            maxFreq = charFreq > maxFreq ? charFreq : maxFreq;
        }

        for (int i = 0; i < str.length(); i++) {
            if (Character.isWhitespace(str.charAt(i))) {
                continue;
            }
            int charFreq = 1;
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    charFreq++;
                }
            }
            if (charFreq == maxFreq) {
                list.add(str.charAt(i));
            }
        }

        Collections.sort(list);

        for (Character c : list) {
            System.out.println("Character '" + c + "' appears " + maxFreq + " times.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        computeMaxFreq(str);
    }
}