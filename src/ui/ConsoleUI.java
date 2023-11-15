package ui;

import java.util.Scanner;
import tour.*;

public class ConsoleUI {
    private TourManager tourManager;
    private TourAgency tourAgency;

    public ConsoleUI(int tourPackagesNumber, int clientsNumber) {
        initializeTourManager(tourPackagesNumber, clientsNumber);
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
                    displaySortTypeMenu();
                    int choiceSortType = getUserChoice(scanner);
                    switch (choiceSortType) {
                        case 1:
                            tourManager.sortTourPackagesByPrice();
                            tourAgency.displayTourPackages();
                            break;
                        case 2:
                            tourManager.sortTourPackagesByDuration();
                            tourAgency.displayTourPackages();
                            break;
                        case 3:
                            tourManager.sortTourPackagesByCountry();
                            tourAgency.displayTourPackages();
                            break;
                        case 4:
                            tourManager.sortTourPackagesByTourType();
                            tourAgency.displayTourPackages();
                            break;
                        case 5:
                            tourManager.sortTourPackagesByTransportType();
                            tourAgency.displayTourPackages();
                            break;
                        case 6:
                            tourManager.sortTourPackagesByMealsType();
                            tourAgency.displayTourPackages();
                            break;
                        case 7:
                            System.out.println("Ok. Moving back to main menu.");
                            //scanner.close();
                            break;
                        default:
                            System.out.println("Wrong choice. Try again.");
                    }
                    break;
                case 3:
                    displayClientsInfo();
                    break;
                case 4:
                    selectTourPackage(scanner);
                    break;
                case 5:
                    System.out.println("Thank you for using our services. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong choice. Try again.");
            }
        }
    }
    private void initializeTourManager(int tourPackagesNumber, int clientsNumber) {

        this.tourManager = new TourManager();
        for (int i = 0; i < tourPackagesNumber; i++) {
            tourManager.addTourPackage(TourGenerator.generateRandomTour());
        }
        this.tourAgency = new TourAgency(tourManager);
        for (int i = 0; i < clientsNumber; i++) {
            Client client = ClientGenerator.generateClient();
            tourAgency.addClient(client);
        }
    }

    private void displayMainMenu() {
        System.out.println("\nMain menu:");
        System.out.println("1. View available tour packages");
        System.out.println("2. Sort available tour packages");
        System.out.println("3. View client information");
        System.out.println("4. Choose a tour package");
        System.out.println("5. Quit");
        System.out.print("Your choice: ");
    }

    private void displaySortTypeMenu() {
        System.out.println("\n\tSort type menu:");
        System.out.println("\t1. Price");
        System.out.println("\t2. Duration");
        System.out.println("\t3. Countries (alphabet order)");
        System.out.println("\t4. Tour type");
        System.out.println("\t5. Transport type");
        System.out.println("\t6. Meals type");
        System.out.println("\t7. Back to main menu");
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
            int packageId = getUserChoice(scanner);

            if (packageId > 0 && packageId <= tourManager.getTourPackages().size()) {
                TourPackage selectedPackage = tourManager.getTourPackageById(packageId);
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
