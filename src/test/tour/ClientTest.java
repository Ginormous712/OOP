package test.tour;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tour.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    private Client client;
    private TourPackage tourPackage1;
    private TourPackage tourPackage2;

    @BeforeEach
    void setUp() {
        client = new Client("John", "Doe", "john.doe@example.com");
        tourPackage1 = new TourPackage(new String[]{"Spain"}, TourType.RELAXATION, 7, TransportType.BUS, MealType.AI, 1000.0);
        tourPackage2 = new TourPackage(new String[]{"Italy", "France"}, TourType.EXCURSION, 5, TransportType.PLANE, MealType.BB, 800.0);
    }

    @AfterEach
    void cleanUp() {
        tourPackage1 = null;
        tourPackage2 = null;
        TourPackage.resetIdCounter();
    }

    @Test
    void testClientInitialization() {
        assertAll("Client properties",
                () -> assertEquals("John", client.getFirstName(), "First name does not match"),
                () -> assertEquals("Doe", client.getLastName(), "Last name does not match"),
                () -> assertEquals("john.doe@example.com", client.getEmail(), "Email does not match"),
                () -> assertTrue(client.getSelectedPackages().isEmpty(), "Selected packages should be empty")
        );
    }
    @org.junit.jupiter.api.Test
    void testAddSelectedPackage() {
        client.addSelectedPackage(tourPackage1);
        client.addSelectedPackage(tourPackage2);

        List<TourPackage> selectedPackages = client.getSelectedPackages();
        assertEquals(2, selectedPackages.size());
        assertTrue(selectedPackages.containsAll(Arrays.asList(tourPackage1, tourPackage2)));
    }

    @org.junit.jupiter.api.Test
    void testRemoveSelectedPackage() {
        client.addSelectedPackage(tourPackage1);
        client.addSelectedPackage(tourPackage2);

        client.removeSelectedPackage(tourPackage1);

        List<TourPackage> selectedPackages = client.getSelectedPackages();
        assertEquals(1, selectedPackages.size());
        assertTrue(selectedPackages.contains(tourPackage2));
    }

    @org.junit.jupiter.api.Test
    void testSelectedPackagesId() {
        String expected = "[NO TOUR PACKAGES]";
        String result = client.selectedPackagesId();

        assertEquals(expected, result);

        client.addSelectedPackage(tourPackage1);
        client.addSelectedPackage(tourPackage2);

        expected = "[ 1, 2 ]";
        result = client.selectedPackagesId();

        assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        client.addSelectedPackage(tourPackage1);
        client.addSelectedPackage(tourPackage2);

        String expected = "Client #1\n" +
                "Name: John Doe\n" +
                "Email: john.doe@example.com\n" +
                "Selected Packages: [ 1, 2 ]";

        String result = client.toString();

        assertEquals(expected, result);
    }
}