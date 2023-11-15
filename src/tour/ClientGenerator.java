package tour;

import java.util.Random;

public class ClientGenerator {
    private static final String[] FIRST_NAMES = {"John", "Alice", "Bob", "Eva", "David", "Emma", "Michael", "Olivia", "William", "Sophia"};
    private static final String[] LAST_NAMES = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor"};
    private static final String[] EMAIL_DOMAINS = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com"};

    public static Client generateClient() {
        Random random = new Random();

        String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
        String email = generateRandomEmail(firstName, lastName);

        return new Client(firstName, lastName, email);
    }

    private static String generateRandomEmail(String firstName, String lastName) {
        Random random = new Random();
        String domain = EMAIL_DOMAINS[random.nextInt(EMAIL_DOMAINS.length)];

        return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + domain;
    }
}