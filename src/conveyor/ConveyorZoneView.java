package conveyor;

import javax.swing.*;

import java.awt.*;

/**
 * Created by alex on 26.11.17.
 */
public class ConveyorZoneView extends JPanel {

    ConveyorZoneView() {
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    void clear() {
        removeAll();
        revalidate();
        repaint();
    }
}
