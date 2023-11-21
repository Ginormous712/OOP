package test.tour;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import tour.*;
class TourTypeTest {

    @Test
    void testEnumValues() {
        TourType[] tourTypes = TourType.values();

        assertEquals(5, tourTypes.length);
        assertArrayEquals(new TourType[]{TourType.RELAXATION, TourType.EXCURSION, TourType.HEALTH, TourType.SHOPPING, TourType.CRUISE}, tourTypes);
    }
}