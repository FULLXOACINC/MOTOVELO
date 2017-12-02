package delivery;

import detail.Detail;
import pipeline.Pipeline;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by alex on 26.11.17.
 */
public class Delivery {
    private DeliveryView view;
    private DeliveryModel model;

    public Delivery(ActionListener deliveryAddAction, ActionListener deliveryPrevAction, ActionListener deliveryNextAction, List<Detail> currentZoneDetails) {
        view = new DeliveryView();
        model = new DeliveryModel();

        JButton btn = new JButton("Add");
        btn.addActionListener(deliveryAddAction);
        view.addButton(btn);

        JButton btn1 = new JButton("Prev");
        btn1.addActionListener(deliveryPrevAction);
        view.addPrevAndNext(btn1);

        JButton btn2 = new JButton("Next");
        btn2.addActionListener(deliveryNextAction);
        view.addPrevAndNext(btn2);

        model.setDetails(currentZoneDetails);
    }

    public JPanel getView() {
        return view.getView();
    }

    public DeliveryView getDeliveryView() {
        return view;
    }

    public DeliveryModel getModel() {
        return model;
    }
}
