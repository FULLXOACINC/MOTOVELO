package pipeline;

import detail.Bike;
import detail.Detail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 26.11.17.
 */
public class PipelineModel {
    private List<PipelineZoneController> zones;
    private int current;

    PipelineModel() {
        current = 0;
        zones = new ArrayList<>();
    }

    void addZone() {
        zones.add(new PipelineZoneController());
    }


    public PipelineZoneController getCurrent() {
        return zones.get(current);
    }

    void setNext() {
        PipelineZoneController current = zones.get(this.current);
        if(current.getModel().getDitales().size()!= this.current +1)
            return;
        PipelineZoneController next = zones.get(++this.current);
        next.setModel(current.getModel());
        current.getView().clear();
        next.update();
    }

    List<PipelineZoneController> getZones() {
        return zones;
    }

    public Bike getRandomBike() {
        List<Detail> details = new ArrayList<>();
        for (PipelineZoneController zone : zones) details.add(zone.getModel().getRandomDetail());
        return new Bike(details);
    }

    void addToZone(Detail detail) {
        PipelineZoneController curr = zones.get(current);
        PipelineZoneModel model =curr.getModel();
        if(model.getDitales().size()>current)
            return;
        model.addDetail(detail);
        curr.update();
    }

    void clear() {
        for (PipelineZoneController controller: zones) {
            controller.getModel().clear();
            controller.getView().clear();
            controller.update();
        }
        current=0;
    }

    List<Detail> getDetailsToCraft() {
        PipelineZoneModel finishZoneModel= zones.get(zones.size() - 1).getModel();
        return finishZoneModel.getDitales();
    }

    public List<Detail> getCurrentZoneDetails() {
        PipelineZoneModel currentZoneModel= getCurrent().getModel();
        return currentZoneModel.getZoneDetails();
    }
}
