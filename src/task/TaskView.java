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
    private Bike bike;
    private JPanel drowPanel;
    private JLabel lable;


    TaskView() {
        lable= new JLabel("",SwingConstants.CENTER);
        bike = new Bike();
        drowPanel = new JPanel();
        setLayout(new GridLayout(1, 2, 0, 0));
        setBorder(BorderFactory.createLineBorder(Color.black));
        add(drowPanel);
        add(lable);
    }

    void setLable(int points, int timer, int money){
        lable.setText("<html>Time: "+timer+"<br>points"+points+"<br>money: "+money+"</html>");
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
            detail.getView().print(drowPanel.getGraphics());
        }
    }

    void remove() {
        drowPanel.removeAll();
        lable.setText("");
        setEmpty();
        revalidate();
        repaint();

    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public Bike getBike() {
        return bike;
    }
}
