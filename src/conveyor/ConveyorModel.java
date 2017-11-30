package conveyor;

import detail.Bike;
import detail.Detail;
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
        zones = new ArrayList<>();
    }

    void addZone() {
        zones.add(new ConveyerZoneController());
    }


    public ConveyerZoneController getCurrent() {
        return zones.get(current);
    }

    void setNext() {
        ConveyerZoneController curr = zones.get(current);
        if(curr.getModel().getDitales().size()!=current+1)
            return;
        ConveyerZoneController next = zones.get(++current);
        next.setModel(curr.getModel());
        curr.getView().clear();
        next.update();
    }

    List<ConveyerZoneController> getZones() {
        return zones;
    }

    public Bike getRandomBike() {
        List<Detail> details = new ArrayList<>();
        for (ConveyerZoneController zone : zones) details.add(zone.getModel().getRandomDetail());
        return new Bike(details);
    }

    void addToZone(Detail detail) {
        ConveyerZoneController curr = zones.get(current);
        ConveyerZoneModel model =curr.getModel();
        if(model.getDitales().size()>current)
            return;
        model.addDetail(detail);
        curr.update();
    }

    void clear() {
        for (ConveyerZoneController controller: zones) {
            controller.getModel().clear();
            controller.getView().clear();
            controller.update();
        }
        current=0;
    }
}
