package tour;
public class TourPackage {
    private static int idCounter;
    private final int id;
    private final String[] countries;
    private final TourType type;
    private final int duration;
    private final TransportType transport;
    private final MealType meals;
    private final double price;

    static {
        idCounter = 1;
    }

    public TourPackage(String[] countries, TourType type, int duration,
                       TransportType transport, MealType meals, double price) {
        this.id = idCounter++;
        this.countries = countries;
        this.type = type;
        this.duration = duration;
        this.transport = transport;
        this.meals = meals;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String[] getCountries() {
        return countries;
    }

    public TourType getType() {
        return type;
    }

    public int getDuration() {
        return duration;
    }

    public TransportType getTransport() {
        return transport;
    }

    public MealType getMeals() {
        return meals;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Tour Package #%d\n" +
                        "Countries: %s\n" +
                        "Type: %s\n" +
                        "Duration: %d days\n" +
                        "Transport: %s\n" +
                        "Meals: %s\n" +
                        "Price: $%.2f",
                id, String.join(", ", countries), type, duration, transport, meals, price);
    }
}
