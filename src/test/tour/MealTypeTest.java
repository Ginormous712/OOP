package test.tour;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import tour.*;
class MealTypeTest {

    @Test
    void testEnumValues() {
        MealType[] mealTypes = MealType.values();

        assertEquals(5, mealTypes.length);
        assertArrayEquals(new MealType[]{MealType.RO, MealType.BB, MealType.HB, MealType.FB, MealType.AI}, mealTypes);
    }
}