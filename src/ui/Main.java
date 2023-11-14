package ui;

import tour.*;


public class Main {
    public static void main(String[] args) {
        TourManager tourManager = new TourManager();

        for (int i = 0; i < 10; i++) {
            tourManager.addTourPackage(TourGenerator.generateRandomTour());
        }

        //tourManager.displayTourPackages();
        //tourManager.sortTourPackagesByPrice();
        //tourManager.sortTourPackagesByCountry();
        //tourManager.sortTourPackagesByDuration();
        //tourManager.sortTourPackagesByTourType();
        //tourManager.sortTourPackagesByTransportType();
        //tourManager.sortTourPackagesByMealsType();

        //tourManager.displayTourPackages();
        //TourAgency tourAgency = new TourAgency(tourManager);
        ConsoleUI consoleUI = new ConsoleUI(10);
        consoleUI.start();
    }
}