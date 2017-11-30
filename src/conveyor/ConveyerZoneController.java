package conveyor;

import detail.Detail;

/**
 * Created by alex on 26.11.17.
 */
public class ConveyerZoneController {
    private final int X_OFFSET=80;
    private final int Y_OFFSET=0;
    private ConveyerZoneModel model;
    private ConveyorZoneView view;

    ConveyerZoneController() {
        model = new ConveyerZoneModel();
        view = new ConveyorZoneView();
    }

    public ConveyerZoneModel getModel() {
        return model;
    }


    void setModel(ConveyerZoneModel model) {
        this.model.setDetails(model.getDitales());
    }

    void update() {
        view.removeAll();
        for (Detail detail : model.getDitales()) {
            detail.getView().print(view.getGraphics(),X_OFFSET,Y_OFFSET);
        }
    }

    ConveyorZoneView getView() {
        return view;
    }
}
