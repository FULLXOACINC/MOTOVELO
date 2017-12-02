package delivery;

import detail.Detail;

import javax.swing.*;
import java.awt.*;

/**
 * Created by alex on 26.11.17.
 */
public class DeliveryView {
    private final int X_OFFSET = 120;
    private final int Y_OFFSET = 0;
    private JPanel drowDitail;
    private JPanel prevAndNextButton;
    private JPanel buttons;
    private JPanel view;
    private JLabel price;

    DeliveryView() {
        drowDitail = new JPanel();
        buttons = new JPanel();
        view = new JPanel();
        price = new JLabel("", SwingConstants.CENTER);
        price.setFont(new Font(price.getFont().getName(), Font.PLAIN, 35));
        view.setLayout(new GridLayout(1, 2, 0, 0));
        drowDitail.setBorder(BorderFactory.createLineBorder(Color.black));
        prevAndNextButton = new JPanel();
        buttons.setBorder(BorderFactory.createLineBorder(Color.black));
        buttons.setLayout(new GridLayout(2, 1, 0, 0));
        prevAndNextButton.setLayout(new GridLayout(1, 2, 0, 0));
        buttons.add(prevAndNextButton);
        view.add(drowDitail);
        view.add(price);
        view.add(buttons);
    }

    public void update(Detail detail) {
        drowDitail.removeAll();
        detail.getView().print(drowDitail.getGraphics(), X_OFFSET, Y_OFFSET);
        price.setText(detail.getModel().getPrice() + "$");
    }

    void addButton(JButton button) {
        buttons.add(button);
    }

    void addPrevAndNext(JButton button) {
        prevAndNextButton.add(button);
    }

    public void clear() {
        view.repaint();
        price.setText("");
    }

    public JPanel getView() {
        return view;
    }
}
