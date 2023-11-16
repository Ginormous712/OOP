package tour;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private static int idCounter;
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private List<TourPackage> selectedPackages;

    static {
        idCounter = 1;
    }
    public Client(String firstName, String lastName, String email) {
        this.id = idCounter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.selectedPackages = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public List<TourPackage> getSelectedPackages() {
        return selectedPackages;
    }

    public void addSelectedPackage(TourPackage tourPackage) {
        selectedPackages.add(tourPackage);
    }

    public void removeSelectedPackage(TourPackage tourPackage) {
        selectedPackages.remove(tourPackage);
    }

    public String selectedPackagesId() {
        if (selectedPackages.size() == 0) {
            return "[NO TOUR PACKAGES]";
        }

        StringBuilder result = new StringBuilder();

        for (TourPackage tourPackage: selectedPackages) {
            result.append(tourPackage.getId()).append(", ");
            //result.concat(", ");
        }

        result.delete(result.length() - 2, result.length());

        return String.format("[ %s ]", result.toString());
    }
    @Override
    public String toString() {
        return String.format("Client #%d\n" +
                        "Name: %s %s\n" +
                        "Email: %s\n" +
                        "Selected Packages: %s",
                id, firstName, lastName, email, selectedPackagesId());
    }
}
