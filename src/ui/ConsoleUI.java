package ui;

import java.util.Scanner;
import tour.*;

public class ConsoleUI {
    private TourManager tourManager;
    private TourAgency tourAgency;

    public ConsoleUI(int tourPackagesNumber) {
        initializeTourManager(tourPackagesNumber);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the travel agency!");

        while (true) {
            displayMainMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    displayTourPackages();
                    break;
                case 2:
                    displayClientsInfo();
                    break;
                case 3:
                    selectTourPackage(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using our services. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong choice. Try again.");
            }
        }
    }
    private void initializeTourManager(int tourPackagesNumber) {

        this.tourManager = new TourManager();
        for (int i = 0; i < tourPackagesNumber; i++) {
            tourManager.addTourPackage(TourGenerator.generateRandomTour());
        }
        this.tourAgency = new TourAgency(tourManager);
    }

    private void displayMainMenu() {
        System.out.println("\nMain menu:");
        System.out.println("1. View available tour packages");
        System.out.println("2. View client information");
        System.out.println("3. Choose a tour package");
        System.out.println("4. Quit");
        System.out.print("Your choice: ");
    }

    private int getUserChoice(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void displayTourPackages() {
        System.out.println("\nAvailable tour packages:");
        //tourManager.
        tourManager.displayTourPackages();
    }

    private void displayClientsInfo() {
        System.out.println("\nClient Information:");
        tourAgency.displayClientInfo();
    }

    private void selectTourPackage(Scanner scanner) {
        System.out.println("\nSelect customer (enter index):");
        tourAgency.displayClientInfo();

        int clientIndex = getUserChoice(scanner) - 1;

        if (clientIndex >= 0 && clientIndex < tourAgency.getClients().size()) {
            System.out.println("\nSelect a tour package for the client:");
            tourManager.displayTourPackages();
            int packageIndex = getUserChoice(scanner) - 1;

            if (packageIndex >= 0 && packageIndex < tourManager.getTourPackages().size()) {
                TourPackage selectedPackage = tourManager.getTourPackages().get(packageIndex);
                tourAgency.selectTourPackage(tourAgency.getClients().get(clientIndex), selectedPackage);
                System.out.println("The tour package was successfully selected for the client.");
            } else {
                System.out.println("Wrong choice of tour package.");
            }
        } else {
            System.out.println("Incorrect client selection.");
        }
    }
}
