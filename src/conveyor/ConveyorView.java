package conveyor;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by alex on 25.11.17.
 */
public class ConveyorView extends JPanel {

    ConveyorView() {
        setLayout(new GridLayout(1, 5, 0, 0));
        setBorder(BorderFactory.createLineBorder(Color.black));
    }


    void setView(List<ConveyorZoneView> view) {
        removeAll();
        for (ConveyorZoneView zone : view) {
            add(zone);
        }
    }
}
