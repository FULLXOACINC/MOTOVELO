package conveyor;

import detail.Detail;
import detail.DetailView;
import detail.TorkDetail;

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
        DetailView dv;
        if (current % 2 == 0)
            dv = new Detail();
        else
            dv = new TorkDetail();
        next.getModel().addDetail(dv);
        next.update();
    }

    public List<ConveyerZoneController> getZones() {
        return zones;
    }

}
