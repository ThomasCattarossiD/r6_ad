package movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final String _name;
    private final List<Rental> _rentals = new ArrayList<>();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.add(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {

        // Initialisation de totalAmount et frequentRenterPoints
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        // Initialisation du StringBuilder pour permettre de retourner notre résultat souhaité
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");

        // Boucle itérative sur chaque film loué
        for (Rental each : _rentals) {

            // Calcul du montant et des frequentRenterPoints
            double thisAmount = determineAmountForEachLine(each);
            frequentRenterPoints += calculateFrequentRenterPoints(each);

            // Résultat de chaque film
            result.append("\t").append(each.getMovie().getTitle()).append("\t").append(thisAmount).append("\n");
            totalAmount += thisAmount;
        }

        // Résultat total
        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
        return result.toString();
    }

    // Méthode pour calculer le montant pour chaque ligne de location
    private double determineAmountForEachLine(Rental rental) {
        double thisAmount = 0;
        // Switch pour la détermination du montant de chaque film
        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (rental.getDaysRented() > 2)
                    thisAmount += (rental.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                thisAmount += rental.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (rental.getDaysRented() > 3)
                    thisAmount += (rental.getDaysRented() - 3) * 1.5;
                break;
        }
        return thisAmount;
    }

    // Méthode pour calculer les points de fidélité pour chaque location
    private int calculateFrequentRenterPoints(Rental rental) {
        int points = 1;
        if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE && rental.getDaysRented() > 1)
            points++;
        return points;
    }
}
