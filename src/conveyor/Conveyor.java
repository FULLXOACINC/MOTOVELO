package conveyor;

import detail.Bike;
import detail.Detail;
import detail.Stock;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 26.11.17.
 */
public class Conveyor {
    private static final String[] DETAILS_TYPE = {"Wheel", "Frame", "York"};
    private ConveyorView view;
    private ConveyorModel model;
    private final int ZONE_COUNT = 3;
    private Stock stock;

    public Conveyor(Stock stock,ActionListener nextAction) {
        this.stock = stock;
        view = new ConveyorView();
        model = new ConveyorModel();
        for (int index = 0; index < ZONE_COUNT; index++) {
            model.addZone();
        }
        List<ConveyorZoneView> zoneView = new ArrayList<ConveyorZoneView>();
        for (ConveyerZoneController controller : model.getZones()) {
            zoneView.add(controller.getView());
        }
        for (int index = 0; index < DETAILS_TYPE.length; index++)
            model.getZones().get(index).getModel().setZoneDetails(DETAILS_TYPE[index]);
        view.setView(zoneView);

        JButton btn = new JButton("NEXT!!!!");
        btn.addActionListener(nextAction);
        view.add(btn);

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
        if (model.getCurrent().getModel().getDitales().size() != ZONE_COUNT)
            model.setNext();
        else {
            stock.add(new Bike(model.getZones().get(ZONE_COUNT - 1).getModel().getDitales()));
            clearConveyor();
        }

    }

    private void clearConveyor() {
        model.clear();
    }

    public ConveyorModel getModel() {
        return model;
    }

    public void add(Detail detail) {
        model.addToZone(detail);
    }
}
