package test.tour;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import tour.*;
class TransportTypeTest {

    @Test
    void testEnumValues() {
        TransportType[] transportTypes = TransportType.values();

        assertEquals(4, transportTypes.length);
        assertArrayEquals(new TransportType[]{TransportType.PLANE, TransportType.BUS, TransportType.TRAIN, TransportType.CRUISE}, transportTypes);
    }
}