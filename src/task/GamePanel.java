package task;

import javax.swing.*;

/**
 * Created by alex on 29.11.17.
 */
public class GamePanel extends JPanel {
    private GameModel model;
    private JLabel information;

    public GamePanel(GameModel model) {
        this.model = model;
        information = new JLabel(setInformation(), SwingConstants.CENTER);
        add(information);
    }

    void update() {
        information.setText(setInformation());
    }

    GameModel getModel() {
        return model;
    }

    private String setInformation() {
        return "<html>Time: " + model.getTime() + "<br>X" + model.getxFactor() + "<br>Failed: " + model.getFailed() + "<br>Points: " + model.getPoints() + "<br>Bike in stock: " + model.getBikeCount() + "</html>";
    }
}
