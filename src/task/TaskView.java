package task;

import detail.Bike;
import detail.Detail;

import javax.swing.*;

import java.awt.*;
import java.util.List;

/**
 * Created by alex on 27.11.17.
 */
public class TaskView {
    private final int X_OFFSET = 10;
    private final int Y_OFFSET = 0;
    private Bike bike;
    private JPanel view;
    private JPanel drowPanel;
    private JLabel taskInf;

    TaskView() {
        taskInf = new JLabel("", SwingConstants.CENTER);
        bike = new Bike();
        drowPanel = new JPanel();
        view = new JPanel();
        view.setLayout(new GridLayout(1, 2, 0, 0));
        view.setBorder(BorderFactory.createLineBorder(Color.black));
        view.add(drowPanel);
        view.add(taskInf);
    }

    void setLable(int points, int timer, int money) {
        taskInf.setText("<html>Time: " + timer + "<br>Points: " + points + "<br>Money: " + money + "</html>");
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
        taskInf.setText("");
        setEmpty();
        view.revalidate();
        view.repaint();

    }

    void setBike(Bike bike) {
        this.bike = bike;
    }

    Bike getBike() {
        return bike;
    }

    public JPanel getView() {
        return view;
    }
}
