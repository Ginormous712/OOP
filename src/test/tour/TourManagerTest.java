package test.tour;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import tour.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class TourManagerTest {
    private TourManager tourManager;
    private TourPackage tourPackage1;
    private TourPackage tourPackage2;

    @BeforeEach
    void setUp() {
        tourManager = new TourManager();
        tourPackage1 = new TourPackage(new String[]{"Spain"}, TourType.EXCURSION, 7, TransportType.BUS, MealType.AI, 1000.0);
        tourPackage2 = new TourPackage(new String[]{"Italy", "France"}, TourType.RELAXATION, 5, TransportType.PLANE, MealType.BB, 800.0);
    }

    @Test
    void addTourPackage() {
        // Add a tour package
        tourManager.addTourPackage(tourPackage1);

        // Check if the tour package is in the list
        assertTrue(tourManager.getTourPackages().contains(tourPackage1));
    }

    @Test
    void getTourPackages() {
        // Add tour packages
        tourManager.addTourPackage(tourPackage1);
        tourManager.addTourPackage(tourPackage2);

        // Check if the returned list is not null and contains the added tour packages
        assertNotNull(tourManager.getTourPackages());
        assertTrue(tourManager.getTourPackages().contains(tourPackage1));
        assertTrue(tourManager.getTourPackages().contains(tourPackage2));
    }

    @Test
    void getTourPackageById() {
        // Add tour packages
        tourManager.addTourPackage(tourPackage1);
        tourManager.addTourPackage(tourPackage2);

        // Check if the correct tour package is retrieved by ID
        assertEquals(tourPackage1, tourManager.getTourPackageById(tourPackage1.getId()));
        assertEquals(tourPackage2, tourManager.getTourPackageById(tourPackage2.getId()));

        // Check if null is returned for an invalid ID
        assertNull(tourManager.getTourPackageById(999));
    }

    @Test
    void displayTourPackages() {
        // Add tour packages
        tourManager.addTourPackage(tourPackage1);
        tourManager.addTourPackage(tourPackage2);

        // Redirect the console output to capture it
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Display tour packages
        tourManager.displayTourPackages();

        // Reset the standard output
        System.setOut(System.out);

        // Check if the output contains information about the added tour packages
        assertTrue(outContent.toString().contains(tourPackage1.toString()));
        assertTrue(outContent.toString().contains("---------------------------"));
        assertTrue(outContent.toString().contains(tourPackage2.toString()));
    }

    @Test
    void testSortTourPackagesByPrice() {
        tourManager.addTourPackage(tourPackage1);
        tourManager.addTourPackage(tourPackage2);

        // Before sorting
        assertEquals(tourPackage1, tourManager.getTourPackages().get(0));
        assertEquals(tourPackage2, tourManager.getTourPackages().get(1));

        // Sorting
        tourManager.sortTourPackagesByPrice();

        // After sorting
        assertNotEquals(tourPackage1, tourManager.getTourPackages().get(0));
        assertNotEquals(tourPackage2, tourManager.getTourPackages().get(1));
    }

    @Test
    void testSortTourPackagesByDuration() {
        tourManager.addTourPackage(tourPackage1);
        tourManager.addTourPackage(tourPackage2);

        // Before sorting
        assertEquals(tourPackage1, tourManager.getTourPackages().get(0));
        assertEquals(tourPackage2, tourManager.getTourPackages().get(1));

        // Sorting
        tourManager.sortTourPackagesByDuration();

        // After sorting
        assertNotEquals(tourPackage1, tourManager.getTourPackages().get(0));
        assertNotEquals(tourPackage2, tourManager.getTourPackages().get(1));
    }

    @Test
    void testSortTourPackagesByCountry() {
        tourManager.addTourPackage(tourPackage1);
        tourManager.addTourPackage(tourPackage2);

        // Before sorting
        assertEquals(tourPackage1, tourManager.getTourPackages().get(0));
        assertEquals(tourPackage2, tourManager.getTourPackages().get(1));

        // Sorting
        tourManager.sortTourPackagesByCountry();

        // After sorting
        assertNotEquals(tourPackage1, tourManager.getTourPackages().get(0));
        assertNotEquals(tourPackage2, tourManager.getTourPackages().get(1));
    }

    @Test
    void testSortTourPackagesByTourType() {
        tourManager.addTourPackage(tourPackage1);
        tourManager.addTourPackage(tourPackage2);

        // Before sorting
        assertEquals(tourPackage1, tourManager.getTourPackages().get(0));
        assertEquals(tourPackage2, tourManager.getTourPackages().get(1));

        // Sorting
        tourManager.sortTourPackagesByTourType();

        // After sorting
        assertNotEquals(tourPackage1, tourManager.getTourPackages().get(0));
        assertNotEquals(tourPackage2, tourManager.getTourPackages().get(1));
    }

    @Test
    void testSortTourPackagesByTransportType() {
        tourManager.addTourPackage(tourPackage1);
        tourManager.addTourPackage(tourPackage2);

        // Before sorting
        assertEquals(tourPackage1, tourManager.getTourPackages().get(0));
        assertEquals(tourPackage2, tourManager.getTourPackages().get(1));

        // Sorting
        tourManager.sortTourPackagesByTransportType();

        // After sorting
        assertNotEquals(tourPackage1, tourManager.getTourPackages().get(0));
        assertNotEquals(tourPackage2, tourManager.getTourPackages().get(1));
    }

    @Test
    void testSortTourPackagesByMealsType() {
        tourManager.addTourPackage(tourPackage1);
        tourManager.addTourPackage(tourPackage2);

        // Before sorting
        assertEquals(tourPackage1, tourManager.getTourPackages().get(0));
        assertEquals(tourPackage2, tourManager.getTourPackages().get(1));

        // Sorting
        tourManager.sortTourPackagesByMealsType();

        // After sorting
        assertNotEquals(tourPackage1, tourManager.getTourPackages().get(0));
        assertNotEquals(tourPackage2, tourManager.getTourPackages().get(1));
    }
}