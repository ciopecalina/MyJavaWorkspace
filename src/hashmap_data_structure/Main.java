package hashmap_data_structure;

import java.util.*;

class CarRentalSystem {

    private final Map<String, String> rentedCars = new HashMap<>(100, 0.5f);
    private final Map<String, RentedCars> rentedCarsByOwner = new HashMap<>(100, 0.5f);

    private static String getPlateNo(Scanner sc) {
        System.out.println("Introduceti numarul de inmatriculare:");
        return sc.nextLine();
    }

    private static String getOwnerName(Scanner sc) {
        System.out.println("Introduceti numele proprietarului:");
        return sc.nextLine();
    }

    private boolean isCarRent(String plateNo) {
        return rentedCars.containsKey(plateNo);
    }

    private String getCarRent(String plateNo) {
        return rentedCars.getOrDefault(plateNo, "Masina " + plateNo + " nu a fost inchiriata.");
    }

    private void rentCar(String plateNo, String ownerName) {
        if (isCarRent(plateNo)) {
            System.out.println("Masina " + plateNo + " a fost deja inchiriata de " + getCarRent(plateNo) + ".");
        } else {
            RentedCars rentedCarsCheck = rentedCarsByOwner.get(ownerName);
            if (rentedCarsCheck == null) {
                rentedCarsCheck = new RentedCars();
                rentedCarsByOwner.put(ownerName, rentedCarsCheck);
            }

            rentedCars.put(plateNo, ownerName);
            rentedCarsCheck.add(plateNo);
            System.out.println("Masina " + plateNo + " a fost inchiriata cu succes.");
        }
    }

    private void returnCar(String plateNo) {
        String ownerName = rentedCars.get(plateNo);
        if (ownerName != null) {
            rentedCars.remove(plateNo);
            RentedCars rentedCarsToRemoveFrom = rentedCarsByOwner.get(ownerName);
            rentedCarsToRemoveFrom.remove(plateNo);
            System.out.println("Masina " + plateNo + " inchiriata de " + ownerName + " a fost returnata.");
        } else {
            System.out.println("Masina nu a fost gasita. Nu s-au efectuat modificari.");
        }
    }

    private int totalCarsRented() {
        return rentedCars.size();
    }

    private void getCarsNo(String ownerName) {
        RentedCars rentedCarsToGetSizeOf = rentedCarsByOwner.get(ownerName);
        if (rentedCarsToGetSizeOf != null) {
            System.out.println(rentedCarsToGetSizeOf.size());
        } else {
            System.out.println(ownerName + " nu a inchiriat nicio masina.");
        }
    }

    private void getCarsList(String ownerName) {
        RentedCars rentedCarsToShow = rentedCarsByOwner.get(ownerName);
        if (rentedCarsToShow != null) {
            System.out.println(rentedCarsToShow.showCars());
        } else {
            System.out.println(ownerName + " nu a inchiriat nicio masina.");
        }
    }

    private static void printCommandsList() {
        System.out.println("help         - Afiseaza aceasta lista de comenzi");
        System.out.println("add          - Adauga o noua pereche (masina, sofer)");
        System.out.println("check        - Verifica daca o masina este deja luata");
        System.out.println("remove       - Sterge o masina existenta din hashtable");
        System.out.println("getOwner     - Afiseaza proprietarul curent al masinii");
        System.out.println("totalRented  - Afiseaza numarul de masini inchiriate");
        System.out.println("getCarsNo    - Afiseaza numarul de masini inchiriate de un anumit proprietar");
        System.out.println("getCarsList  - Afiseaza lista de masini inchiriate de un anumit proprietar");
        System.out.println("quit         - Inchide aplicatia");
    }

    public void run(Scanner sc) {
        boolean quit = false;

        while (!quit) {
            String command = sc.nextLine();

            switch (command) {
                case "help":
                    printCommandsList();
                    break;
                case "add":
                    String plateNoAdd = getPlateNo(sc);
                    String ownerName = getOwnerName(sc);
                    rentCar(plateNoAdd, ownerName);
                    break;
                case "check":
                    String plateNoCheck = getPlateNo(sc);
                    String ownerCheck = getCarRent(plateNoCheck);
                    System.out.println(isCarRent(plateNoCheck)
                            ? "Masina " + plateNoCheck + " a fost inchiriata de " + ownerCheck + "."
                            : "Masina cautata nu a fost inchiriata.");
                    break;
                case "remove":
                    String plateNoRemove = getPlateNo(sc);
                    returnCar(plateNoRemove);
                    break;
                case "getOwner":
                    String plateNoGetOwner = getPlateNo(sc);
                    System.out.println(getCarRent(plateNoGetOwner));
                    break;
                case "totalRented":
                    System.out.println(totalCarsRented());
                    break;
                case "getCarsNo":
                    getCarsNo(getOwnerName(sc));
                    break;
                case "getCarsList":
                    getCarsList(getOwnerName(sc));
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
    private final List<String> rentedCarsByOwnerList;

    public RentedCars() {
        rentedCarsByOwnerList = new ArrayList<>();
    }

    public void add(String plateNo) {
        rentedCarsByOwnerList.add(plateNo);
    }

    public void remove(String plateNo) {
        rentedCarsByOwnerList.remove(plateNo);
    }

    public int size() {
        return rentedCarsByOwnerList.size();
    }

    public String showCars() {
        return rentedCarsByOwnerList.toString();
    }
}


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarRentalSystem carRentalSystem = new CarRentalSystem();
        carRentalSystem.run(scanner);
    }
}