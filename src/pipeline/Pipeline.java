package pipeline;

import detail.Bike;
import detail.Detail;
import detail.Stock;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 26.11.17.
 */
public class Pipeline {
    private static final String[] DETAILS_TYPE = {"Wheel", "Frame", "York"};
    private PipelineView view;
    private PipelineModel model;
    private final int ZONE_COUNT = 3;
    private Stock stock;

    public Pipeline(Stock stock, ActionListener nextAction) {
        this.stock = stock;
        view = new PipelineView(1, ZONE_COUNT + 1);
        model = new PipelineModel();
        for (int index = 0; index < ZONE_COUNT; index++) {
            model.addZone();
        }
        List<PipelineZoneView> zoneView = new ArrayList<>();

        for (PipelineZoneController controller : model.getZones()) {
            zoneView.add(controller.getPipelineZoneView());
        }

        for (int index = 0; index < DETAILS_TYPE.length; index++) {
            model.getZones().get(index).getModel().setZoneDetails(DETAILS_TYPE[index]);
        }
        view.setView(zoneView);

        JButton btn = new JButton("NEXT!!!!");
        btn.addActionListener(nextAction);
        view.getView().add(btn);

        update();
    }

    private void update() {
        for (PipelineZoneController zone : model.getZones())
            zone.update();
    }

    public JPanel getView() {
        return view.getView();
    }

    public void next() {
        if (model.getCurrent().getCountOfDetails() != ZONE_COUNT)
            model.setNext();
        else {
            stock.add(new Bike(model.getDetailsToCraft()));
            clearPipeline();
        }

    }

    private void clearPipeline() {
        model.clear();
    }

    public PipelineModel getModel() {
        return model;
    }

    public void add(Detail detail) {
        model.addToZone(detail);
    }
}
