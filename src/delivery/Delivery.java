package delivery;

import pipeline.Pipeline;

import javax.swing.*;

/**
 * Created by alex on 26.11.17.
 */
public class Delivery {
    private DeliveryView view;
    private DeliveryModel model;

    public Delivery(Pipeline pipeline) {
        view = new DeliveryView();
        model = new DeliveryModel();

        JButton btn = new JButton("Add");
        btn.addActionListener(e -> {
            view.update(model.getCurrentDetail());
            pipeline.add(model.getCurrentDetail());
        });
        view.addButton(btn);

        JButton bt2 = new JButton("Prev");
        bt2.addActionListener(e -> {
            model.prevDetail();
            view.update(model.getCurrentDetail());
        });
        view.addPrevAndNext(bt2);

        JButton btn1 = new JButton("Next");
        btn1.addActionListener(e -> {
            model.nextDetail();
            view.update(model.getCurrentDetail());
        });
        view.addPrevAndNext(btn1);

        model.setDetails(pipeline.getModel().getCurrentZoneDetails());
    }

    public DeliveryView getView() {
        return view;
    }

    public DeliveryModel getModel() {
        return model;
    }
}
