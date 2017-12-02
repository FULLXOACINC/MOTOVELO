package delivery;

import detail.Detail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 26.11.17.
 */
public class DeliveryModel {
    private List<Detail> details;
    private Detail currentDetail;

    DeliveryModel() {
        details = new ArrayList<>();
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
        currentDetail = details.get(0);
    }

    public void nextDetail() {
        int current = details.indexOf(currentDetail);
        if (current == details.size() - 1)
            current = 0;
        else
            current++;
        currentDetail = details.get(current);
    }

    public void prevDetail() {
        int current = details.indexOf(currentDetail);
        if (current == 0)
            current = details.size() - 1;
        else
            current--;
        currentDetail = details.get(current);
    }

    public Detail getCurrentDetail() {
        return currentDetail;
    }

    public List<Detail> getDetails() {
        return details;
    }
}
