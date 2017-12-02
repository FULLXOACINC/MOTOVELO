package detail;

import java.awt.*;
import java.awt.geom.Line2D;

/**
 * Created by alex on 26.11.17.
 */
public class YorkDetail implements DetailView {
    private Color color;
    private int width;

    public YorkDetail(Color color, int width) {
        this.color = color;
        this.width = width;
    }

    @Override
    public void print(Graphics view, int xOffset, int yOffset) {
        Graphics2D g2 = (Graphics2D) view;
        g2.setStroke(new BasicStroke(width));
        g2.setPaint(color);
        g2.draw(new Line2D.Float(PrintParametrs.POINT_FRAME_UP_RIGHT_X + xOffset, PrintParametrs.POINT_FRAME_UP_Y + yOffset, PrintParametrs.POINT_YORK_END_X + xOffset, PrintParametrs.POINT_YORK_END_Y + yOffset));
    }
}
