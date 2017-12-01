package detail;

import java.awt.*;

/**
 * Created by alex on 27.11.17.
 */
public class WheelDetail implements WheelView {
    private Color color;
    private int width;
    private final int RADIUS = 25;

    public WheelDetail(Color color, int width) {
        this.color = color;
        this.width = width;
    }

    @Override
    public void print(Graphics view, int xOffset, int yOffset) {
        Graphics2D g2 = (Graphics2D) view;
        g2.setStroke(new BasicStroke(width));
        g2.setPaint(color);
        int diameter = RADIUS * 2;
        g2.drawOval(PrintParametrs.POINT_RIGHT_WHEEL_X - RADIUS + xOffset, PrintParametrs.POINT_WHEEL_Y - RADIUS + yOffset, diameter, diameter);
        g2.drawOval(PrintParametrs.POINT_LEFT_WHEEL_X - RADIUS + xOffset, PrintParametrs.POINT_WHEEL_Y - RADIUS + yOffset, diameter, diameter);
    }
}
