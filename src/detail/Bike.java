package detail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 29.11.17.
 */
public class Bike {
    private List<Detail> detailes;
    private int summ;

    public Bike(List<Detail> detailes) {
        this.detailes = detailes;
        countSumm();
    }

    private void countSumm() {
        summ=0;
        for (Detail detail : detailes) {
            summ+=detail.getModel().getPrice();
        }
    }

    public Bike() {
        detailes = new ArrayList<>();
    }

    public boolean equals(Bike bike) {
        boolean zeroSize = bike.getDetailes().size() == 0 || detailes.size() == 0;
        boolean sizeNotEqual = bike.getDetailes().size() != detailes.size();
        if (zeroSize || sizeNotEqual)
            return false;
        for (Detail detail : detailes) {
            boolean isEqual=false;
            for (Detail d : bike.getDetailes()) {
                if(detail.equals(d))
                    isEqual=true;
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

    public int getSumm() {
        return summ;
    }
}
