package delivery;

import conveyor.Conveyor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by alex on 26.11.17.
 */
public class Delivery {
    private DeliveryView view;
    private DeliveryModel model;

    public Delivery(Conveyor conv) {
        view = new DeliveryView();
        model = new DeliveryModel();

        JButton btn = new JButton("Add");
        btn.addActionListener(e -> conv.add(model.getCurrentDetail()));
        view.addButton(btn);
        JButton btn1 = new JButton("next");
        btn1.addActionListener(e -> {
            model.nextDetail();
            view.update(model.getCurrentDetail());
        });
        view.addButton(btn1);
        JButton bt2 = new JButton("prev");
        bt2.addActionListener(e -> {
            model.prevDetail();
            view.update(model.getCurrentDetail());
        });
        view.addButton(bt2);
        //TODO rewrite this
        model.setDetails(conv.getModel().getCurrent().getModel().getZoneDetails());
    }

    public DeliveryView getView() {
        return view;
    }


    public DeliveryModel getModel() {
        return model;
    }
}
