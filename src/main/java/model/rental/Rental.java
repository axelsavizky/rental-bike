package model.rental;

public abstract class Rental {

    public int calculatePrice(int time) {
        return this.getRate()*time;
    }

    public abstract int getRate();
}
