package model.rental;

public class PairRentalTime {
    private Rental rental;
    private int time;

    public PairRentalTime(Rental rental, int time) {
        this.rental = rental;
        this.time = time;
    }

    public PairRentalTime() {
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
