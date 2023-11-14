package tour;

import java.util.*;

public class TourManager {
    private List<TourPackage> tourPackages;

    public TourManager() {
        tourPackages = new ArrayList<>();
    }

    public void addTourPackage(TourPackage tourPackage) {
        tourPackages.add(tourPackage);
    }

    public List<TourPackage> getTourPackages() {
        return tourPackages;
    }

    public void displayTourPackages() {
        for (TourPackage tourPackage : tourPackages) {
            System.out.println(tourPackage);
            System.out.println("---------------------------");
        }
    }

    private static class PriceComparator implements Comparator<TourPackage> {
        @Override
        public int compare(TourPackage tour1, TourPackage tour2) {
            return Double.compare(tour1.getPrice(), tour2.getPrice());
        }
    }

    private static class DurationComparator implements Comparator<TourPackage> {
        @Override
        public int compare(TourPackage tour1, TourPackage tour2) {
            return Integer.compare(tour1.getDuration(), tour2.getDuration());
        }
    }

    private static class CountryComparator implements Comparator<TourPackage> {
        @Override
        public int compare(TourPackage tour1, TourPackage tour2) {
            Arrays.sort(tour1.getCountries());
            Arrays.sort(tour2.getCountries());

            return String.CASE_INSENSITIVE_ORDER.compare(tour1.getCountries()[0], tour2.getCountries()[0]);
        }
    }

    private static class TourTypeComparator implements Comparator<TourPackage> {
        @Override
        public int compare(TourPackage tour1, TourPackage tour2) {
            return tour1.getType().compareTo(tour2.getType());
        }
    }

    private static class TransportTypeComparator implements Comparator<TourPackage> {
        @Override
        public int compare(TourPackage tour1, TourPackage tour2) {
            return tour1.getTransport().compareTo(tour2.getTransport());
        }
    }

    private static class MealTypeComparator implements Comparator<TourPackage> {
        @Override
        public int compare(TourPackage tour1, TourPackage tour2) {
            return tour1.getMeals().compareTo(tour2.getMeals());
        }
    }
    public void sortTourPackagesByPrice() {
        Collections.sort(tourPackages, new PriceComparator());
    }

    public void sortTourPackagesByDuration() {
        Collections.sort(tourPackages, new DurationComparator());
    }

    public void sortTourPackagesByCountry() {
        Collections.sort(tourPackages, new CountryComparator());
    }

    public void sortTourPackagesByTourType() {
        Collections.sort(tourPackages, new TourTypeComparator());
    }

    public void sortTourPackagesByTransportType() {
        Collections.sort(tourPackages, new TransportTypeComparator());
    }

    public void sortTourPackagesByMealsType() {
        Collections.sort(tourPackages, new MealTypeComparator());
    }




}
