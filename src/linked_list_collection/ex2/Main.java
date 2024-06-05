package linked_list_collection.ex2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    private static void removeDuplicates(LinkedList<Integer> list) {
        if (list.isEmpty() || list.size() == 1) {
            return;
        }

        ListIterator<Integer> iterator = list.listIterator();
        int previous = iterator.next();

        while (iterator.hasNext()) {
            int current = iterator.next();
            if (current == previous) {
                iterator.remove();
            } else {
                previous = current;
            }
        }
    }

    private static void removeDuplicates2(LinkedList<Integer> list) {
        if (list.isEmpty() || list.size() == 1) {
            return;
        }

        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> duplicates = new HashSet<>();
        ListIterator<Integer> iterator = list.listIterator();

        while (iterator.hasNext()) {
            int current = iterator.next();
            if (seen.contains(current)) {
                duplicates.add(current);
            } else {
                seen.add(current);
            }
        }

        iterator = list.listIterator();
        while (iterator.hasNext()) {
            int current = iterator.next();
            if (duplicates.contains(current)) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        while (scanner.hasNext()) {
            int x = scanner.nextInt();
            list.add(x);
        }

        if (a == 1) removeDuplicates(list);
        else removeDuplicates2(list);

        System.out.println(list);
    }
}
