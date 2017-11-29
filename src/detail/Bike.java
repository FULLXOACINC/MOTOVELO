package detail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 29.11.17.
 */
public class Bike {
    private List<Detail> detailes;

    public Bike(List<Detail> detailes) {
        this.detailes = detailes;
    }

    public Bike() {
        detailes = new ArrayList<>();
    }

    public boolean equalBike(Bike bike) {
        boolean zeroSize = bike.getDetailes().size() == 0 || detailes.size() == 0;
        boolean sizeNotEqual = bike.getDetailes().size() != detailes.size();
        if (zeroSize || sizeNotEqual)
            return false;
        for (Detail detail : detailes) {
            boolean isEqual=false;
            for (Detail d : bike.getDetailes()) {
                isEqual=detail.equals(d);
            }
            if(!isEqual)
                return false;
        }
        return true;
    }

    public List<Detail> getDetailes() {
        return detailes;
    }

    public void setDitailes(List<Detail> ditailes) {
        this.detailes = ditailes;
    }
}
