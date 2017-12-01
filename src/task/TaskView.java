package task;

import detail.Bike;
import detail.Detail;

import javax.swing.*;

import java.awt.*;
import java.util.List;

/**
 * Created by alex on 27.11.17.
 */
public class TaskView extends JPanel {
    private final int X_OFFSET = 10;
    private final int Y_OFFSET = 0;
    private Bike bike;
    private JPanel drowPanel;
    private JLabel lable;


    TaskView() {
        lable = new JLabel("", SwingConstants.CENTER);
        bike = new Bike();
        drowPanel = new JPanel();
        setLayout(new GridLayout(1, 2, 0, 0));
        setBorder(BorderFactory.createLineBorder(Color.black));
        add(drowPanel);
        add(lable);
    }

    void setLable(int points, int timer, int money) {
        lable.setText("<html>Time: " + timer + "<br>Points: " + points + "<br>Money: " + money + "</html>");
    }

    List<Detail> getElements() {
        return bike.getDetailes();
    }


    private void setEmpty() {
        bike.getDetailes().removeAll(bike.getDetailes());
    }

    void setElements(List<Detail> elements) {
        bike.setDitailes(elements);
    }

    boolean isEmpty() {
        return bike.getDetailes().isEmpty();
    }

    void update() {
        drowPanel.removeAll();
        for (Detail detail : bike.getDetailes()) {
            detail.getView().print(drowPanel.getGraphics(), X_OFFSET, Y_OFFSET);
        }
    }

    void remove() {
        drowPanel.removeAll();
        lable.setText("");
        setEmpty();
        revalidate();
        repaint();

    }

    void setBike(Bike bike) {
        this.bike = bike;
    }

    Bike getBike() {
        return bike;
    }
}
