package pipeline;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by alex on 25.11.17.
 */
public class PipelineView extends JPanel {

    PipelineView(int lines, int parts) {
        setLayout(new GridLayout(lines, parts, 0, 0));
        setBorder(BorderFactory.createLineBorder(Color.black));
    }


    void setView(List<PipelineZoneView> view) {
        removeAll();
        for (PipelineZoneView zone : view) {
            add(zone);
        }
    }
}
