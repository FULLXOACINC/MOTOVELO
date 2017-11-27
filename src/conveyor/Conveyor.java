package conveyor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 26.11.17.
 */
public class Conveyor {
    ConveyorView view;
    ConveyorModel model;
    private final int ZONE_COUNT = 4;

    public Conveyor() {
        view = new ConveyorView();
        model = new ConveyorModel();
        for (int index = 0; index < ZONE_COUNT; index++) {
            model.addZone();
        }
        List<ConveyorZoneView> zoneView = new ArrayList<ConveyorZoneView>();
        for (ConveyerZoneController controller : model.getZones()) {
            zoneView.add(controller.getView());
        }
        view.setView(zoneView);
        update();
    }

    private void update() {
        for (ConveyerZoneController zone : model.getZones())
            zone.update();
    }

    public ConveyorView getView() {
        return view;
    }

    public void next() {
        if (model.getZones().indexOf(model.getCurrent()) != ZONE_COUNT - 1)
            model.setNext();
    }
}
