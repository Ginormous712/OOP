package test.tour;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import tour.*;
class ClientGeneratorTest {

    private static final String[] FIRST_NAMES = {"John", "Alice", "Bob", "Eva", "David", "Emma", "Michael", "Olivia", "William", "Sophia"};
    private static final String[] LAST_NAMES = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor"};
    private static final String[] EMAIL_DOMAINS = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com"};

    @Test
    void testGenerateClient() {
        Client client = ClientGenerator.generateClient();

        assertNotNull(client);
        assertContains(FIRST_NAMES, client.getFirstName());
        assertContains(LAST_NAMES, client.getLastName());
        String clientEmail = client.getFirstName().toLowerCase() + "."
                + client.getLastName().toLowerCase()
                + getDomainFromEmail(client.getEmail());
        assertEquals(client.getEmail(), clientEmail);
    }

    private void assertContains(String[] array, String value) {
        assertTrue(array.length > 0 && contains(array, value));
    }

    private boolean contains(String[] array, String value) {
        for (String element : array) {
            if (element.equals(value)) {
                return true;
            }
        }
        return false;
    }

    private String getDomainFromEmail(String email) {
        int atIndex = email.indexOf('@');
        if (atIndex != -1) {
            return email.substring(atIndex);
        }
        return null;
    }
}