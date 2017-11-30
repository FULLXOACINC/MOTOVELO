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

        g2.draw(new Line2D.Float(PrintParametrs.POINT_LEFT_WHEEL_X, PrintParametrs.POINT_WHEEL_Y, PrintParametrs.POINT_FRAME_UP_LEFT_X,  PrintParametrs.POINT_FRAME_UP_Y));
        g2.draw(new Line2D.Float(PrintParametrs.POINT_FRAME_UP_LEFT_X, PrintParametrs.POINT_FRAME_UP_Y, PrintParametrs.POINT_FRAME_UP_RIGHT_X, PrintParametrs.POINT_FRAME_UP_Y));
        g2.draw(new Line2D.Float(PrintParametrs.POINT_FRAME_DOWN_LEFT_X, PrintParametrs.POINT_WHEEL_Y, PrintParametrs.POINT_FRAME_DOWN_RIGHT_X, PrintParametrs.POINT_WHEEL_Y));
        g2.draw(new Line2D.Float(PrintParametrs.POINT_FRAME_DOWN_RIGHT_X, PrintParametrs.POINT_WHEEL_Y, PrintParametrs.POINT_FRAME_UP_RIGHT_X, PrintParametrs.POINT_FRAME_UP_Y));
        g2.draw(new Line2D.Float(PrintParametrs.POINT_FRAME_UP_LEFT_X, PrintParametrs.POINT_FRAME_UP_Y, PrintParametrs.POINT_FRAME_DOWN_RIGHT_X, PrintParametrs.POINT_WHEEL_Y));
        g2.draw(new Line2D.Float(PrintParametrs.POINT_FRAME_UP_RIGHT_X, PrintParametrs.POINT_FRAME_UP_Y, PrintParametrs.POINT_RIGHT_WHEEL_X, PrintParametrs.POINT_WHEEL_Y));

    }
}
