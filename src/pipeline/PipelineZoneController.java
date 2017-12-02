package pipeline;


import javax.swing.*;

/**
 * Created by alex on 26.11.17.
 */
public class PipelineZoneController {
    private PipelineZoneModel model;
    private PipelineZoneView view;

    PipelineZoneController() {
        model = new PipelineZoneModel();
        view = new PipelineZoneView();
    }

    public PipelineZoneModel getModel() {
        return model;
    }

    void setModel(PipelineZoneModel model) {
        this.model.setDetails(model.getDitales());
    }

    void update() {
        view.update(model.getDitales());
    }

    PipelineZoneView getPipelineZoneView() {
        return view;
    }

    JPanel getView() {
        return view.getView();
    }

    int getCountOfDetails() {
        return model.getDitales().size();
    }
}
