package pipeline;

import detail.Detail;

import javax.swing.*;

import java.awt.*;

import java.util.List;

/**
 * Created by alex on 26.11.17.
 */
public class PipelineZoneView extends JPanel {
    private final int X_OFFSET = 80;
    private final int Y_OFFSET = 0;

    PipelineZoneView() {
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    void clear() {
        removeAll();
        revalidate();
        repaint();
    }

    public void update(List<Detail> details) {
        removeAll();
        for (Detail detail : details) {
            detail.getView().print(getGraphics(), X_OFFSET, Y_OFFSET);
        }
    }

}
