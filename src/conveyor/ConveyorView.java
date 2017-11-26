package conveyor;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 25.11.17.
 */
public class ConveyorView extends JPanel{
    private List conveyorZoneViews;

    public ConveyorView() {
        conveyorZoneViews = new ArrayList<ConveyorZoneView>();
        setLayout(new GridLayout(1,5,0,0));
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    void addZone(){
        ConveyorZoneView zone = new ConveyorZoneView();
        conveyorZoneViews.add(zone);
        add(zone);

    }
}
