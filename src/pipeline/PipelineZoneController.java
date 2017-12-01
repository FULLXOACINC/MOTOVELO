package pipeline;


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

    PipelineZoneView getView() {
        return view;
    }

    int getCountOfDetails(){
        return model.getDitales().size();
    }
}
