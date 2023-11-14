package tour;

public enum TourType {
    RELAXATION("Relaxation"),
    EXCURSION("Excursion"),
    HEALTH("Health"),
    SHOPPING("Shopping"),
    CRUISE("Cruise");

    private final String type;

    TourType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
