package tour;

import java.util.ArrayList;
import java.util.List;

public class TourAgency {
    private List<Client> clients;
    private TourManager tourManager;

    public TourAgency(TourManager tourManager) {
        this.clients = new ArrayList<>();
        this.tourManager = tourManager;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void selectTourPackage(Client client, TourPackage tourPackage) {
        client.addSelectedPackage(tourPackage);
    }

    public void displayClientInfo() {
        for (Client client : clients) {
            System.out.println(client);
        }
    }

    public void displayTourPackages() {
        tourManager.displayTourPackages();
    }
}
