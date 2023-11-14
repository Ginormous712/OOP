package tour;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;
public class TourGenerator {
    private static final String[] COUNTRIES = {"Italy", "Spain", "France", "Greece", "USA", "Japan", "Australia", "Brazil", "Germany", "Thailand", "Canada"};

    public static TourPackage generateRandomTour() {
        Random random = new Random();

        int numberOfCountries = random.nextInt(3) + 1;

        Set<String> selectedCountriesSet = new HashSet<>();

        // Add unique countries to Set
        while (selectedCountriesSet.size() < numberOfCountries) {
            selectedCountriesSet.add(COUNTRIES[random.nextInt(COUNTRIES.length)]);
        }

        // Set to Array
        String[] selectedCountries = selectedCountriesSet.toArray(new String[0]);


        // Choosing a random type of travel voucher
        TourType randomTourType = TourType.values()[random.nextInt(TourType.values().length)];

        // Select a random transport type
        TransportType randomTransportType = TransportType.values()[random.nextInt(TransportType.values().length)];

        // Choosing a random power type
        MealType randomMealType = MealType.values()[random.nextInt(MealType.values().length)];

        // Generation of random duration from 1 to 14 days
        int randomDuration = random.nextInt(14) + 1;

        // Random price generation from 1000 to 5000
        double randomPrice = (Math.round((1000 + random.nextDouble() * 4000) / 100.0)) * 100;

        return new TourPackage(selectedCountries, randomTourType, randomDuration, randomTransportType, randomMealType, randomPrice);
    }
}
