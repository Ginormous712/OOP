package test.tour;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import tour.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class TourAgencyTest {

    private TourManager tourManager;
    private TourAgency tourAgency;
    private Client client1;
    private Client client2;
    private TourPackage tourPackage1;
    private TourPackage tourPackage2;

    @BeforeEach
    void setUp() {
        tourManager = new TourManager();
        tourAgency = new TourAgency(tourManager);
        client1 = new Client("John", "Doe", "john.doe@example.com");
        client2 = new Client("Alice", "Smith", "alice.smith@example.com");
        tourPackage1 = new TourPackage(new String[]{"Spain"}, TourType.RELAXATION, 7, TransportType.BUS, MealType.AI, 1000.0);
        tourPackage2 = new TourPackage(new String[]{"Italy", "France"}, TourType.EXCURSION, 5, TransportType.PLANE, MealType.BB, 800.0);
    }

    @Test
    void testGetClients() {
        // Add clients to the agency
        tourAgency.addClient(client1);
        tourAgency.addClient(client2);

        // Check if the returned list is not null and contains the added clients
        assertNotNull(tourAgency.getClients());
        assertTrue(tourAgency.getClients().contains(client1));
        assertTrue(tourAgency.getClients().contains(client2));
    }

    @Test
    void testAddClient() {
        // Add a client to the agency
        tourAgency.addClient(client1);

        // Check if the client is in the list
        assertTrue(tourAgency.getClients().contains(client1));
    }

    @Test
    void testSelectTourPackage() {
        // Add a client and tour packages
        tourAgency.addClient(client1);
        tourManager.addTourPackage(tourPackage1);
        tourManager.addTourPackage(tourPackage2);

        // Select a tour package for the client
        tourAgency.selectTourPackage(client1, tourPackage1);

        // Check if the selected package is in the client's list
        assertTrue(client1.getSelectedPackages().contains(tourPackage1));
    }

    @Test
    void testDisplayClientInfo() {
        // Add clients to the agency
        tourAgency.addClient(client1);
        tourAgency.addClient(client2);

        // Redirect the console output to capture it
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Display client information
        tourAgency.displayClientInfo();

        // Reset the standard output
        System.setOut(System.out);

        // Check if the output contains information about the added clients
        assertTrue(outContent.toString().contains(client1.toString()));
        assertTrue(outContent.toString().contains("---------------------------"));
        assertTrue(outContent.toString().contains(client2.toString()));
    }

    @Test
    void testDisplayTourPackages() {
        // Add tour packages to the manager
        tourManager.addTourPackage(tourPackage1);
        tourManager.addTourPackage(tourPackage2);

        // Redirect the console output to capture it
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Display tour packages through the agency
        tourAgency.displayTourPackages();

        // Reset the standard output
        System.setOut(System.out);

        // Check if the output contains information about the added tour packages
        assertTrue(outContent.toString().contains(tourPackage1.toString()));
        assertTrue(outContent.toString().contains("---------------------------"));
        assertTrue(outContent.toString().contains(tourPackage2.toString()));
    }
}