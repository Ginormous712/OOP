package test.tour;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import tour.*;
class TourGeneratorTest {

    @Test
    void testGenerateRandomTour() {
        TourPackage generatedTour = TourGenerator.generateRandomTour();

        // Check if the generatedTour is not null
        assertNotNull(generatedTour);

        // Check if the generatedTour countries are within the valid list
        for (String country : generatedTour.getCountries()) {
            assertTrue(isValidCountry(country));
        }

        // Check if the generatedTour type is within the valid TourType values
        assertTrue(isValidEnumValue(generatedTour.getType(), TourType.class));

        // Check if the generatedTour transport is within the valid TransportType values
        assertTrue(isValidEnumValue(generatedTour.getTransport(), TransportType.class));

        // Check if the generatedTour meals is within the valid MealType values
        assertTrue(isValidEnumValue(generatedTour.getMeals(), MealType.class));

        // Check if the generatedTour duration is within the valid range (1 to 14 days)
        assertTrue(generatedTour.getDuration() >= 1 && generatedTour.getDuration() <= 14);

        // Check if the generatedTour price is within the valid range (1000 to 5000)
        assertTrue(generatedTour.getPrice() >= 1000.0 && generatedTour.getPrice() <= 5000.0);

        // Check if the generatedTour price is a multiple of 100
        assertEquals(0, generatedTour.getPrice() % 100);
    }
    private boolean isValidCountry(String country) {
        String[] validCountries = {"Italy", "Spain", "France", "Greece", "USA", "Japan", "Australia", "Brazil", "Germany", "Thailand", "Canada"};

        for (String validCountry : validCountries) {
            if (validCountry.equalsIgnoreCase(country)) {
                return true;
            }
        }

        return false;
    }

    private <T extends Enum<T>> boolean isValidEnumValue(Enum<?> value, Class<T> enumType) {
        for (T enumConstant : enumType.getEnumConstants()) {
            if (enumConstant.name().equals(value.name())) {
                return true;
            }
        }
        return false;
    }
}