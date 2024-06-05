package my_int_arraylist;

import java.util.*;

class MyIntArrayList {

    private int[] elements;
    private int size;

    private void increaseSize() {
        this.elements = Arrays.copyOf(this.elements, this.elements.length * 2);
    }

    public MyIntArrayList() {
        this(10);
    }

    public MyIntArrayList(MyIntArrayList c) {
        this.size = c.size;
        this.elements = Arrays.copyOf(c.elements, c.elements.length);
    }

    public MyIntArrayList(int initialCapacity) {
        this.elements = new int[initialCapacity];
    }

    public void add(int index, int element) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (this.size >= this.elements.length - 1) {
            increaseSize();
        }

        for (int i = this.size; i > index; i--) {
            this.elements[i] = this.elements[i - 1];
        }

        this.elements[index] = element;
        this.size++;
    }

    public boolean add(int e) {
        if (this.size >= this.elements.length - 1) {
            increaseSize();
        }
        this.elements[this.size] = e;
        this.size++;
        return true;
    }

    public int size() {
        return this.size;
    }

    public boolean contains(int e) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i] == e)
                return true;
        }
        return false;
    }

    public int get(int index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return this.elements[index];
    }

    public int indexOf(int e) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(int e) {
        for (int i = this.size - 1; i >= 0; i--) {
            if (this.elements[i] == e)
                return i;
        }
        return -1;
    }

    public boolean remove(int e) {
        int indexToRemove = -1;

        for (int i = 0; i < this.size; i++) {
            if (this.elements[i] == e) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove != -1) {
            for (int j = indexToRemove; j < this.size - 1; j++) {
                this.elements[j] = this.elements[j + 1];
            }

            this.size--;
            this.elements = Arrays.copyOf(this.elements, this.size);
            return true;
        }

        return false;
    }

    public int removeElementAtIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        int removedElement = this.elements[index];

        for (int i = index; i < this.size - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }

        this.size--;
        this.elements = Arrays.copyOf(this.elements, this.size);
        return removedElement;
    }

    public void clear() {
        this.elements = new int[10];
        this.size = 0;
    }

    public int set(int index, int e) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        int replacedElement = this.elements[index];
        this.elements[index] = e;
        return replacedElement;
    }

    public boolean addAll(MyIntArrayList c) {
        if ((this.size + c.size) >= this.elements.length) {
            this.elements = Arrays.copyOf(this.elements, this.elements.length * 2 + c.elements.length * 2);
        }

        int index = this.size;
        for (int i = 0; i < c.size; i++) {
            this.elements[index] = c.elements[i];
            this.size++;
            index++;
        }
        return true;
    }

    public boolean addAll(int index, MyIntArrayList c) {
        if ((this.size + c.size) >= this.elements.length) {
            this.elements = Arrays.copyOf(this.elements, this.elements.length * 2 + c.elements.length * 2);
        }

        int[] extracted;
        extracted = Arrays.copyOfRange(this.elements, index, this.size);

        int position = index;
        for (int i = 0; i < c.size; i++) {
            this.elements[position] = c.elements[i];
            this.size++;
            position++;
        }

        for (int i = 0; i < extracted.length; i++) {
            this.elements[position] = extracted[i];
            position++;
        }

        return true;
    }

    public int[] toArray() {
        return Arrays.copyOf(this.elements, this.size);
    }

    public void ensureCapacity(int minCapacity) {
        this.elements = Arrays.copyOf(this.elements, minCapacity);
    }

    public void trimToSize() {
        this.elements = Arrays.copyOf(this.elements, this.size);
    }
}

public class Main {
    private static final int CONSTRUCT = 0;
    private static final int COPY = 1;
    private static final int CONSTRUCT_CAP = 2;
    private static final int ADD_INDEX = 3;
    private static final int ADD = 4;
    private static final int REMOVE = 5;
    private static final int CLEAR = 6;
    private static final int ADDALL = 7;
    private static final int ADDALL_INDEX = 8;
    private static final int SET = 9;
    private static final int ENSURE_CAPACITY = 10;
    private static final int TRIM_TO_SIZE = 11;
    private static final int REMOVE_ELEMENT_AT_INDEX = 12;
    private static final int SIZE = 13;
    private static final int CONTAINS = 14;
    private static final int GET = 15;
    private static final int INDEX_OF = 16;
    private static final int LAST_INDEX_OF = 17;
    private static final int TO_ARRAY = 18;

    private static Map<String, Integer> commandsMap = createCommandsMap();

    private static Map<String, Integer> createCommandsMap() {
        Map<String, Integer> myMap = new HashMap<String, Integer>();
        myMap.put("construct", CONSTRUCT);
        myMap.put("copy", COPY);
        myMap.put("constructCap", CONSTRUCT_CAP);
        myMap.put("addIndex", ADD_INDEX);
        myMap.put("add", ADD);
        myMap.put("remove", REMOVE);
        myMap.put("clear", CLEAR);
        myMap.put("addAll", ADDALL);
        myMap.put("addAllIndex", ADDALL_INDEX);
        myMap.put("set", SET);
        myMap.put("ensureCapacity", ENSURE_CAPACITY);
        myMap.put("trimToSize", TRIM_TO_SIZE);
        myMap.put("removeElementAtIndex", REMOVE_ELEMENT_AT_INDEX);
        myMap.put("size", SIZE);
        myMap.put("contains", CONTAINS);
        myMap.put("get", GET);
        myMap.put("indexOf", INDEX_OF);
        myMap.put("lastIndexOf", LAST_INDEX_OF);
        myMap.put("toArray", TO_ARRAY);
        return myMap;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<MyIntArrayList> testArrays = new ArrayList<MyIntArrayList>();
        Integer array, arrayDest, arraySursa, minCap;
        Integer elem, index, cap, res, size;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] params = line.split("\\s+");
            switch (commandsMap.get(params[0])) {
                case CONSTRUCT:
                    testArrays.add(new MyIntArrayList());
                    break;
                case CONSTRUCT_CAP:
                    cap = Integer.parseInt(params[1]);
                    testArrays.add(new MyIntArrayList(cap));
                    break;
                case COPY:
                    array = Integer.parseInt(params[1]);
                    MyIntArrayList copiedArray = testArrays.get(array);
                    testArrays.add(new MyIntArrayList(copiedArray));
                    break;
                case ADD:
                    array = Integer.parseInt(params[1]);
                    elem = Integer.parseInt(params[2]);
                    testArrays.get(array).add(elem);
                    break;
                case ADD_INDEX:
                    array = Integer.parseInt(params[1]);
                    index = Integer.parseInt(params[2]);
                    elem = Integer.parseInt(params[3]);
                    testArrays.get(array).add(index, elem);
                    break;
                case REMOVE:
                    array = Integer.parseInt(params[1]);
                    elem = Integer.parseInt(params[2]);
                    testArrays.get(array).remove(elem);
                    break;
                case CLEAR:
                    array = Integer.parseInt(params[1]);
                    testArrays.get(array).clear();
                    break;
                case ADDALL:
                    arrayDest = Integer.parseInt(params[1]);
                    arraySursa = Integer.parseInt(params[2]);
                    testArrays.get(arrayDest).addAll(testArrays.get(arraySursa));
                    break;
                case ADDALL_INDEX:
                    arrayDest = Integer.parseInt(params[1]);
                    arraySursa = Integer.parseInt(params[2]);
                    index = Integer.parseInt(params[3]);
                    testArrays.get(arrayDest).addAll(index, testArrays.get(arraySursa));
                    break;
                case SET:
                    array = Integer.parseInt(params[1]);
                    index = Integer.parseInt(params[2]);
                    elem = Integer.parseInt(params[3]);
                    testArrays.get(array).set(index, elem);
                    break;
                case ENSURE_CAPACITY:
                    array = Integer.parseInt(params[1]);
                    minCap = Integer.parseInt(params[2]);
                    testArrays.get(array).ensureCapacity(minCap);
                    break;
                case TRIM_TO_SIZE:
                    array = Integer.parseInt(params[1]);
                    testArrays.get(array).trimToSize();
                    break;
                case REMOVE_ELEMENT_AT_INDEX:
                    array = Integer.parseInt(params[1]);
                    index = Integer.parseInt(params[2]);
                    testArrays.get(array).removeElementAtIndex(index);
                    break;
                case SIZE:
                    array = Integer.parseInt(params[1]);
                    size = testArrays.get(array).size();
                    System.out.println(size);
                    break;
                case CONTAINS:
                    array = Integer.parseInt(params[1]);
                    elem = Integer.parseInt(params[2]);
                    boolean result = testArrays.get(array).contains(elem);
                    System.out.println(result);
                    break;
                case GET:
                    array = Integer.parseInt(params[1]);
                    index = Integer.parseInt(params[2]);
                    res = testArrays.get(array).get(index);
                    System.out.println(res);
                    break;
                case INDEX_OF:
                    array = Integer.parseInt(params[1]);
                    elem = Integer.parseInt(params[2]);
                    res = testArrays.get(array).indexOf(elem);
                    System.out.println(res);
                    break;
                case LAST_INDEX_OF:
                    array = Integer.parseInt(params[1]);
                    elem = Integer.parseInt(params[2]);
                    res = testArrays.get(array).lastIndexOf(elem);
                    System.out.println(res);
                    break;
                case TO_ARRAY:
                    array = Integer.parseInt(params[1]);
                    int[] intArray = testArrays.get(array).toArray();
                    System.out.println(Arrays.toString(intArray));
                    break;
            }
        }
    }
}

