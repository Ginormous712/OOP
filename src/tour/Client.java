package tour;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String firstName;
    private String lastName;
    private String email;
    private List<TourPackage> selectedPackages;

    public Client(String firstName, String lastName, String email) {
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

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", selectedPackages=" + selectedPackages +
                '}';
    }
}
