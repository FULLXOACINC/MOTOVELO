package pipeline;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by alex on 25.11.17.
 */
public class PipelineView {
    private JPanel view;

    PipelineView(int lines, int parts) {
        view = new JPanel();
        view.setLayout(new GridLayout(lines, parts, 0, 0));
        view.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    void setView(List<PipelineZoneView> zoneView) {
        view.removeAll();
        for (PipelineZoneView zone : zoneView) {
            view.add(zone.getView());
        }
    }

    public JPanel getView() {
        return view;
    }
}
