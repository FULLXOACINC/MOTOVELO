package conveyor;

import detail.FrameDetail;
import detail.DetailView;
import detail.WheelDetail;
import detail.YorkDetail;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 26.11.17.
 */
public class ConveyorModel {
    private List<ConveyerZoneController> zones;
    private int current;

    ConveyorModel() {
        current = 0;
        zones = new ArrayList<ConveyerZoneController>();
    }

    void addZone() {
        zones.add(new ConveyerZoneController());
    }


    ConveyerZoneController getCurrent() {
        return zones.get(current);
    }

    void setNext() {

        ConveyerZoneController curr = zones.get(current);
        current++;
        ConveyerZoneController next = zones.get(current);
        next.setModel(curr.getModel());
        curr.getView().removeAll();
        curr.getView().revalidate();
        curr.getView().repaint();
        DetailView dv = null;
        if (current % 3 == 0)
            dv = new WheelDetail(Color.GREEN, 5, 20);
        if (current % 3 == 1)
            dv = new FrameDetail(Color.BLUE, 5);
        if (current % 3 == 2)
            dv = new YorkDetail(Color.RED, 5);
        next.getModel().addDetail(dv);
        next.update();
    }

    public List<ConveyerZoneController> getZones() {
        return zones;
    }

}
