package task;

import detail.Bike;
import detail.Detail;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 27.11.17.
 */
public class TaskView extends JPanel {
    private List<Detail> elements;
    private Bike bike;

    TaskView() {
        elements = new ArrayList<Detail>();
        bike = new Bike();
    }


    List<Detail> getElements() {
        return bike.getDetailes();
    }


    private void setEmpty() {
        elements.removeAll(elements);
    }

    void setElements(List<Detail> elements) {
        bike.setDitailes(elements);
    }

    boolean isEmpty() {
        return bike.getDetailes().isEmpty();
    }

    void update() {
        removeAll();
        for (Detail detail : bike.getDetailes()) {
            detail.getView().print(getGraphics());
        }
    }

    void remove() {
        removeAll();
        setEmpty();
        revalidate();
        repaint();

    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }
}
