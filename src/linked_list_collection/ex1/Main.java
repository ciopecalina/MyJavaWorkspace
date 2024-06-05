package linked_list_collection.ex1;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

class OrderedList<T extends Comparable<T>> {

    private final List<T> elements = new LinkedList<>();

    public boolean addInOrderedList(T element) {
        ListIterator<T> li = elements.listIterator();

        while (li.hasNext()) {
            int comparison = li.next().compareTo(element);
            if (comparison < 0) {

            } else if (comparison > 0) {
                li.previous();
                li.add(element);

                return true;
            } else {

                return false;
            }
        }

        li.add(element);

        return true;
    }

    @Override
    public String toString() {
        String str = "";
        for (T element : elements) {
            str += element + "\n";
        }
        return str;
    }
}


class Town implements Comparable<Town> {

    private final String name;
    private final int distance;

    public Town(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        //result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + distance;

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Town)) {
            return false;
        }

        Town townObj = (Town) obj;
        // if (super.equals(townObj) && this.name.equals(townObj.name) && this.distance == townObj.distance) {
        //     return true;
        // }
        if (super.equals(townObj) && this.distance == townObj.distance) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return name + " " + distance;
    }

    @Override
    public int compareTo(Town o) {
        int distanceComparison = Integer.compare(this.distance, o.distance);
        //if (distanceComparison != 0) {
        return distanceComparison;
        //}

        //return this.name.compareTo(o.name);
    }
}


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderedList<Town> orderedTownsList = new OrderedList<>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] params = line.split("\\s+");
            String townName = params[0];
            int distance = Integer.parseInt(params[1]);
            orderedTownsList.addInOrderedList(new Town(townName, distance));
        }

        System.out.print(orderedTownsList);
    }
}
