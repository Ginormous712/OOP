package tour;
public class TourPackage {
    private static int idCounter;
    private int id;
    private String[] countries;
    private TourType type;
    private int duration;
    private String transport;
    private String meals;
    private double price;

    static {
        idCounter = 1;
    }

    public TourPackage(String[] countries, TourType type, int duration, String transport, String meals, double price) {
        this.id = idCounter++;
        this.countries = countries;
        this.type = type;
        this.duration = duration;
        this.transport = transport;
        this.meals = meals;
        this.price = price;
    }
}
