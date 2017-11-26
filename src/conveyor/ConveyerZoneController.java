package conveyor;

import detail.DetailView;

/**
 * Created by alex on 26.11.17.
 */
public class ConveyerZoneController {
    private ConveyerZoneModel model;
    private ConveyorZoneView view;

    public ConveyerZoneController() {
        model = new ConveyerZoneModel();
        view = new ConveyorZoneView();
    }

    public ConveyerZoneModel getModel() {
        return model;
    }


    public void setModel(ConveyerZoneModel model) {
        this.model = model;
    }

    public void update() {
        view.removeAll();
        for (DetailView detail : model.getDitales()) {
            detail.print(view.getGraphics());
        }
    }

    public ConveyorZoneView getView() {
        return view;
    }
}
