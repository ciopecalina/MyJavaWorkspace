package linked_list_collection.extra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class MyIntLinkedList {

    private int size;
    private Node head;
    private Node tail;

    public MyIntLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    public MyIntLinkedList(MyIntLinkedList c) {
        this();
        if (c != null) {
            Node current = c.head;
            while (current != null) {
                this.add(current.getValue());
                current = current.getNext();
            }
        }
    }

    public void add(int index, int element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            insertNodeAtBeginning(element);
        } else if (index == size) {
            insertNodeAtEnd(element);
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            Node newNode = new Node(element, current.getNext(), current);
            current.getNext().setPrevious(newNode);
            current.setNext(newNode);
            size++;
        }
    }

    public boolean add(int e) {
        add(size, e);
        return true;
    }

    public int size() {
        return size;
    }

    public boolean contains(int e) {
        Node current = head;
        while (current != null) {
            if (current.getValue() == e) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }

    public int indexOf(int e) {
        int index = 0;
        Node current = head;
        while (current != null) {
            if (current.getValue() == e) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    public int lastIndexOf(int e) {
        int index = size - 1;
        Node current = tail;
        while (current != null) {
            if (current.getValue() == e) {
                return index;
            }
            current = current.getPrevious();
            index--;
        }
        return -1;
    }

    public boolean remove(int e) {
        Node current = head;
        while (current != null) {
            if (current.getValue() == e) {
                if (current == head) {
                    head = current.getNext();
                    if (head != null) {
                        head.setPrevious(null);
                    }
                } else if (current == tail) {
                    tail = current.getPrevious();
                    tail.setNext(null);
                } else {
                    current.getPrevious().setNext(current.getNext());
                    current.getNext().setPrevious(current.getPrevious());
                }
                size--;
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public int removeElementAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        int value;
        if (index == 0) {
            value = head.getValue();
            head = head.getNext();
            if (head != null) {
                head.setPrevious(null);
            }
        } else if (index == size - 1) {
            value = tail.getValue();
            tail = tail.getPrevious();
            tail.setNext(null);
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            value = current.getValue();
            current.getPrevious().setNext(current.getNext());
            current.getNext().setPrevious(current.getPrevious());
        }
        size--;
        return value;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int set(int index, int e) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        int oldValue = current.getValue();
        current.setValue(e);
        return oldValue;
    }

    public boolean addAll(MyIntLinkedList c) {
        if (c == null || c.size() == 0) {
            return false;
        }
        Node current = c.head;
        while (current != null) {
            this.add(current.getValue());
            current = current.getNext();
        }
        return true;
    }

    public boolean addAll(int index, MyIntLinkedList c) {
        if (index < 0 || index > size) {
            return false;
        }

        if (c == null || c.size() == 0) {
            return false;
        }

        Node current = c.head;
        while (current != null) {
            this.add(index++, current.getValue());
            current = current.getNext();
        }
        return true;
    }

    public int[] toArray() {
        int[] array = new int[size];
        Node current = head;
        int i = 0;
        while (current != null) {
            array[i++] = current.getValue();
            current = current.getNext();
        }
        return array;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node current = head;
        while (current != null) {
            sb.append(current.getValue());
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

    private boolean insertNodeAtBeginning(int el) {
        if (head == null) {
            head = new Node(el);
            tail = head;
        } else {
            Node newNode = new Node(el);
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        }
        size++;
        return true;
    }

    private boolean insertNodeAtEnd(int el) {
        if (tail == null) {
            tail = new Node(el);
            head = tail;
        } else {
            Node newNode = new Node(el);
            newNode.setPrevious(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
        return true;
    }
}

class Node {

    private int value;
    private Node next;
    private Node previous;

    public Node(int value, Node next, Node previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    public Node(int value) {
        this(value, null, null);
    }

    public Node() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return String.format("[%d]", this.value);
    }
}

public class Main {
    private static final int CONSTRUCT = 0;
    private static final int COPY = 1;
    private static final int ADD_INDEX = 3;
    private static final int ADD = 4;
    private static final int REMOVE = 5;
    private static final int CLEAR = 6;
    private static final int ADDALL = 7;
    private static final int ADDALL_INDEX = 8;
    private static final int SET = 9;
    private static final int REMOVE_ELEMENT_AT_INDEX = 12;
    private static final int SIZE = 13;
    private static final int CONTAINS = 14;
    private static final int GET = 15;
    private static final int INDEX_OF = 16;
    private static final int LAST_INDEX_OF = 17;
    private static final int TO_STRING = 18;

    private static Map<String, Integer> commandsMap = createCommandsMap();

    private static Map<String, Integer> createCommandsMap() {
        Map<String, Integer> myMap = new HashMap<String, Integer>();
        myMap.put("construct", CONSTRUCT);
        myMap.put("copy", COPY);
        myMap.put("addIndex", ADD_INDEX);
        myMap.put("add", ADD);
        myMap.put("remove", REMOVE);
        myMap.put("clear", CLEAR);
        myMap.put("addAll", ADDALL);
        myMap.put("addAllIndex", ADDALL_INDEX);
        myMap.put("set", SET);
        myMap.put("removeElementAtIndex", REMOVE_ELEMENT_AT_INDEX);
        myMap.put("size", SIZE);
        myMap.put("contains", CONTAINS);
        myMap.put("get", GET);
        myMap.put("indexOf", INDEX_OF);
        myMap.put("lastIndexOf", LAST_INDEX_OF);
        myMap.put("toString", TO_STRING);
        return myMap;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<MyIntLinkedList> testLists = new ArrayList<MyIntLinkedList>();
        Integer array, arrayDest, arraySursa, minCap;
        Integer elem, index, cap, res, size;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] params = line.split("\\s+");
            switch (commandsMap.get(params[0])) {
                case CONSTRUCT:
                    testLists.add(new MyIntLinkedList());
                    break;

                case COPY:
                    array = Integer.parseInt(params[1]);
                    MyIntLinkedList copiedArray = testLists.get(array);
                    testLists.add(new MyIntLinkedList(copiedArray));
                    break;

                case ADD:
                    array = Integer.parseInt(params[1]);
                    elem = Integer.parseInt(params[2]);
                    testLists.get(array).add(elem);
                    break;

                case ADD_INDEX:
                    array = Integer.parseInt(params[1]);
                    index = Integer.parseInt(params[2]);
                    elem = Integer.parseInt(params[3]);
                    testLists.get(array).add(index, elem);
                    break;

                case REMOVE:
                    array = Integer.parseInt(params[1]);
                    elem = Integer.parseInt(params[2]);
                    testLists.get(array).remove(elem);
                    break;

                case CLEAR:
                    array = Integer.parseInt(params[1]);
                    testLists.get(array).clear();
                    break;

                case ADDALL:
                    arrayDest = Integer.parseInt(params[1]);
                    arraySursa = Integer.parseInt(params[2]);
                    testLists.get(arrayDest).addAll(testLists.get(arraySursa));
                    break;

                case ADDALL_INDEX:
                    arrayDest = Integer.parseInt(params[1]);
                    arraySursa = Integer.parseInt(params[2]);
                    index = Integer.parseInt(params[3]);
                    testLists.get(arrayDest).addAll(index, testLists.get(arraySursa));
                    break;

                case SET:
                    array = Integer.parseInt(params[1]);
                    index = Integer.parseInt(params[2]);
                    elem = Integer.parseInt(params[3]);
                    testLists.get(array).set(index, elem);
                    break;

                case REMOVE_ELEMENT_AT_INDEX:
                    array = Integer.parseInt(params[1]);
                    index = Integer.parseInt(params[2]);
                    testLists.get(array).removeElementAtIndex(index);
                    break;

                case SIZE:
                    array = Integer.parseInt(params[1]);
                    size = testLists.get(array).size();
                    System.out.println(size);
                    break;

                case CONTAINS:
                    array = Integer.parseInt(params[1]);
                    elem = Integer.parseInt(params[2]);
                    boolean result = testLists.get(array).contains(elem);
                    System.out.println(result);
                    break;

                case GET:
                    array = Integer.parseInt(params[1]);
                    index = Integer.parseInt(params[2]);
                    res = testLists.get(array).get(index);
                    System.out.println(res);
                    break;

                case INDEX_OF:
                    array = Integer.parseInt(params[1]);
                    elem = Integer.parseInt(params[2]);
                    res = testLists.get(array).indexOf(elem);
                    System.out.println(res);
                    break;

                case LAST_INDEX_OF:
                    array = Integer.parseInt(params[1]);
                    elem = Integer.parseInt(params[2]);
                    res = testLists.get(array).lastIndexOf(elem);
                    System.out.println(res);
                    break;

                case TO_STRING:
                    array = Integer.parseInt(params[1]);
                    System.out.println(testLists.get(array).toString());
                    break;
            }
        }
    }
}
