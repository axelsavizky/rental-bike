package model.rental;

import java.util.List;
import java.util.Map;

public class FamilyRental {

    private static final double FAMILY_PRICE = 0.7;

    public double calculatePrice(List<PairRentalTime> rentals) {
        if (!(rentals.size() >= 3 && rentals.size() <= 5)) {
            throw new IllegalArgumentException("Rentals size is not family size");
        }

        int totalPrice = rentals.stream().map(pair -> pair.getRental().calculatePrice(pair.getTime()))
                .mapToInt(Integer::intValue).sum();

        return totalPrice * FAMILY_PRICE;
    }
}
