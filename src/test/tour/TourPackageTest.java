package test.tour;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import tour.*;
class TourPackageTest {
    @BeforeAll
    static void setUp() {
        TourPackage.resetIdCounter();
    }

    @Test
    void testTourPackageInitialization() {
        String[] countries = {"Italy", "Spain"};
        TourType type = TourType.RELAXATION;
        int duration = 7;
        TransportType transport = TransportType.PLANE;
        MealType meals = MealType.AI;
        double price = 1500.0;

        TourPackage tourPackage = new TourPackage(countries, type, duration, transport, meals, price);

        assertEquals(1, tourPackage.getId());
        assertArrayEquals(countries, tourPackage.getCountries());
        assertEquals(type, tourPackage.getType());
        assertEquals(duration, tourPackage.getDuration());
        assertEquals(transport, tourPackage.getTransport());
        assertEquals(meals, tourPackage.getMeals());
        assertEquals(price, tourPackage.getPrice());
    }

    @Test
    void testTourPackageToString() {
        String[] countries = {"Italy", "Spain"};
        TourType type = TourType.RELAXATION;
        int duration = 7;
        TransportType transport = TransportType.PLANE;
        MealType meals = MealType.AI;
        double price = 1500.0;

        TourPackage tourPackage = new TourPackage(countries, type, duration, transport, meals, price);

        String expectedToString = "Tour Package #1\n" +
                "Countries: Italy, Spain\n" +
                "Type: RELAXATION\n" +
                "Duration: 7 days\n" +
                "Transport: PLANE\n" +
                "Meals: AI\n" +
                "Price: $1500,00";

        assertEquals(expectedToString, tourPackage.toString());
    }

    @AfterEach
    void tearDown() {
        TourPackage.resetIdCounter();
    }

}