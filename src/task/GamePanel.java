package task;

import detail.Stock;

import javax.swing.*;

/**
 * Created by alex on 29.11.17.
 */
public class GamePanel extends JPanel {
    private GameModel model ;
    private JLabel lable;

    public GamePanel(GameModel model) {
        this.model = model;
        lable = new JLabel(setLable(), SwingConstants.CENTER);
        add(lable);
    }

    void update(){
        lable.setText(setLable());
    }

    GameModel getModel() {
        return model;
    }
    private String setLable(){
        return "<html>Time: "+model.getTime()+"<br>X"+model.getxFactor()+"<br>Failed: "+model.getFailed()+"<br>Points: "+model.getPoints()+"<br>Bike in stock: "+model.getBikeCount()+"</html>";
    }
}
