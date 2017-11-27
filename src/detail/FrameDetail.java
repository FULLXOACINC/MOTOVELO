package detail;

import conveyor.ConveyorZoneView;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

/**
 * Created by alex on 26.11.17.
 */
public class FrameDetail implements FrameView {
    Color color;
    int width;

    public FrameDetail(Color color, int width) {
        this.color = color;
        this.width = width;
    }

    @Override
    public void print(Graphics graphics) {
        Graphics2D g2 = (Graphics2D) graphics;

        g2.setStroke(new BasicStroke(width));
        g2.setPaint(color);

        g2.draw(new Line2D.Float(30, 70, 40, 30));
        g2.draw(new Line2D.Float(40, 30, 100, 30));
        g2.draw(new Line2D.Float(30, 70, 90, 70));
        g2.draw(new Line2D.Float(90, 70, 100, 30));
        g2.draw(new Line2D.Float(40, 30, 90, 70));
        g2.draw(new Line2D.Float(100, 30, 120, 70));

    }
}
