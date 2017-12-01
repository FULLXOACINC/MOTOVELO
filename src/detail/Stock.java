package detail;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 29.11.17.
 */
public class Stock {
    private List<Bike> bikes;

    public Stock() {
        bikes = new ArrayList<>();
    }

    public List<Bike> getBikes() {
        return bikes;
    }

    public void add(Bike bike) {
        bikes.add(bike);
    }

}
