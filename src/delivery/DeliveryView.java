package delivery;

import detail.Detail;

import javax.swing.*;
import java.awt.*;

/**
 * Created by alex on 26.11.17.
 */
public class DeliveryView extends JPanel{
    private JPanel drowDitail;
    private JPanel buttons;
    DeliveryView() {
        drowDitail = new JPanel();
        buttons = new JPanel();
        setLayout(new GridLayout(1, 2, 0, 0));
        drowDitail.setBorder(BorderFactory.createLineBorder(Color.black));
        buttons.setBorder(BorderFactory.createLineBorder(Color.black));
        add(drowDitail);
        add(buttons);
    }

    public void update(Detail detail) {
        drowDitail.removeAll();
        revalidate();
        repaint();
        detail.getView().print(getGraphics());

    }

    public void addButton(JButton button) {
        buttons.add(button);
    }
}
