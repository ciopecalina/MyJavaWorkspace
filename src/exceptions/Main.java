package exceptions;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class CarRentalSystem {

    private static Scanner sc;
    private final HashMap<String, String> rentedCars = new HashMap<>(100, 0.5f);
    private final HashMap<String, RentedCars> owners = new HashMap<>(100, 0.5f);

    public CarRentalSystem(Scanner sc) {
        CarRentalSystem.sc = sc;
    }

    private static String getPlateNo() {
        System.out.println("Introduceti numarul de inmatriculare:");
        return sc.nextLine();
    }

    private static String getOwnerName() {
        System.out.println("Introduceti numele proprietarului:");
        return sc.nextLine();
    }

    private boolean isCarRent(String plateNo) {
        return rentedCars.containsKey(plateNo);
    }

    private String getCarRent(String plateNo) {
        return rentedCars.get(plateNo);
    }

    private void rentCar(String plateNo, String ownerName) {
        rentedCars.put(plateNo, ownerName);

        RentedCars current = owners.get(ownerName);

        if (current == null) {
            RentedCars carList = new RentedCars();
            carList.add(plateNo);
            owners.put(ownerName, carList);
        } else
            current.add(plateNo);
    }

    private String returnCar(String plateNo) {
        String currentOwner = "";

        for (Map.Entry<String, String> entry : rentedCars.entrySet())
            if (entry.getKey().equals(plateNo))
                currentOwner = entry.getValue();

        owners.get(currentOwner).remove(plateNo);

        return rentedCars.remove(plateNo);
    }

    private int totalCarsRented() {
        return rentedCars.size();
    }

    private void getCarsNo(String ownerName) {
        RentedCars result = owners.get(ownerName);
        if (result == null)
            System.out.printf("Nu exista masini inchiriate de [%s].%n", ownerName);
        else
            System.out.println(result.size());
    }

    private void getCarsList(String ownerName) {
        RentedCars result = owners.get(ownerName);
        if (result == null)
            System.out.printf("Nu exista masini inchiriate de [%s].%n", ownerName);
        else
            System.out.println(result.showCars());
    }

    private static void printCommandsList() {
        System.out.println("help         - Afiseaza aceasta lista de comenzi");
        System.out.println("add          - Adauga o noua pereche (masina, sofer)");
        System.out.println("check        - Verifica daca o masina este deja luata");
        System.out.println("remove       - Sterge o masina existenta din hashtable");
        System.out.println("getOwner     - Afiseaza proprietarul curent al masinii");
        System.out.println("totalRented  - Afiseaza numarul de masini inchiriate");
        System.out.println(
                "getCarsNo    - Afiseaza numarul de masini inchiriate de un anumit proprietar");
        System.out.println(
                "getCarsList  - Afiseaza lista de masini inchiriate de un anumit proprietar");
        System.out.println("quit         - Inchide aplicatia");
    }

    public void run() {
        boolean quit = false;

        while (!quit) {
            System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
            String command = sc.nextLine();

            switch (command) {
                case "help":
                    printCommandsList();
                    break;
                case "add":
                    String plateNo = getPlateNo();

                    if (isCarRent(plateNo)) {
                        throw new IllegalArgumentException("Masina a fost deja inchiriata.");
                    } else {
                        rentCar(plateNo, getOwnerName());
                    }
                    break;
                case "check":
                    plateNo = getPlateNo();
                    boolean carRent = isCarRent(plateNo);

                    if (!carRent)
                        System.out.println("Masina cautata nu a fost inchiriata.");
                    else {
                        String current = getCarRent(plateNo);
                        System.out.printf("Masina [%s] a fost inchiriata de [%s].%n", plateNo, current);
                    }
                    break;
                case "remove":
                    plateNo = getPlateNo();
                    carRent = isCarRent(plateNo);

                    if (!carRent) {
                        throw new IllegalArgumentException("Masina nu a fost gasita.");
                    } else {
                        String result = returnCar(plateNo);
                        System.out.printf(
                                "Masina [%s] inchiriata de [%s] a fost returnata. Multumim.%n", plateNo, result);
                    }
                    break;
                case "getOwner":
                    plateNo = getPlateNo();
                    String owner = getCarRent(plateNo);

                    if (owner == null)
                        System.out.printf("Masina [%s] nu a fost inchiriata.%n", plateNo);
                    else
                        System.out.printf("Masina [%s] a fost inchiriata de [%s].%n", plateNo, owner);
                    break;
                case "totalRented":
                    System.out.printf("Sunt [%d] masini inchiriate in total.%n", totalCarsRented());
                    break;
                case "getCarsNo":
                    getCarsNo(getOwnerName());
                    break;
                case "getCarsList":
                    getCarsList(getOwnerName());
                    break;
                case "quit":
                    System.out.println("Aplicatia se inchide...");
                    quit = true;
                    break;
                default:
                    System.out.println("Comanda necunoscuta. Incearca din nou.");
                    printCommandsList();
                    break;
            }
        }
    }
}

class RentedCars {

    private final ArrayList<String> cars;

    public RentedCars() {
        this.cars = new ArrayList<>();
    }

    public void add(String plateNo) {
        cars.add(plateNo);
    }

    public void remove(String plateNo) {
        cars.remove(plateNo);
    }

    public int size() {
        return cars.size();
    }

    public String showCars() {
        return cars.toString();
    }
}

public class Main {
    public static void main(String args[])
            throws IllegalAccessException, IllegalArgumentException, NoSuchMethodException,
            SecurityException, ClassNotFoundException, InstantiationException,
            InvocationTargetException {

        Scanner scanner = new Scanner(System.in);
        Class<?> carRentalSystemClass = CarRentalSystem.class;
        Constructor<?> carRentalSystemConstructor = carRentalSystemClass.getConstructor(Scanner.class);
        Object carRentalSystem = carRentalSystemConstructor.newInstance(scanner);
        Method method = carRentalSystemClass.getMethod("run");

        try {
            method.invoke(carRentalSystem);
        } catch (InvocationTargetException e) {
            Exception thrownException = (Exception) e.getCause();

            if (thrownException instanceof IllegalArgumentException) {
                System.out.println("IllegalArgumentException was thrown!");
            } else {
                System.out.println("Unknown exception was thrown!");
            }
            System.out.println("Exception message: " + thrownException.getMessage());
        }
    }
}