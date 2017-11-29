package conveyor;

import detail.Detail;

/**
 * Created by alex on 26.11.17.
 */
public class ConveyerZoneController {
    private ConveyerZoneModel model;
    private ConveyorZoneView view;

    ConveyerZoneController() {
        model = new ConveyerZoneModel();
        view = new ConveyorZoneView();
    }

    ConveyerZoneModel getModel() {
        return model;
    }


    void setModel(ConveyerZoneModel model) {
        this.model.setDetails(model.getDitales());
    }

    void update() {
        view.removeAll();
        for (Detail detail : model.getDitales()) {
            detail.getView().print(view.getGraphics());
        }
    }

    ConveyorZoneView getView() {
        return view;
    }
}
