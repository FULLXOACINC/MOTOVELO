package pipeline;

import detail.Detail;

import javax.swing.*;

import java.awt.*;

import java.util.List;

/**
 * Created by alex on 26.11.17.
 */
public class PipelineZoneView {
    private final int X_OFFSET = 80;
    private final int Y_OFFSET = 0;
    private JPanel view;

    PipelineZoneView() {
        view = new JPanel();
        view.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    void clear() {
        view.removeAll();
        view.revalidate();
        view.repaint();
    }

    public void update(List<Detail> details) {
        view.removeAll();
        for (Detail detail : details) {
            detail.getView().print(view.getGraphics(), X_OFFSET, Y_OFFSET);
        }
    }

    public JPanel getView() {
        return view;
    }
}
