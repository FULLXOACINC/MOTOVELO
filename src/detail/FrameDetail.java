package detail;

import java.awt.*;
import java.awt.geom.Line2D;

/**
 * Created by alex on 26.11.17.
 */
public class FrameDetail implements DetailView {
    private Color color;
    private int width;

    public FrameDetail(Color color, int width) {
        this.color = color;
        this.width = width;
    }

    @Override
    public void print(Graphics view, int xOffset, int yOffset) {
        Graphics2D g2 = (Graphics2D) view;

        g2.setStroke(new BasicStroke(width));
        g2.setPaint(color);

        g2.draw(new Line2D.Float(PrintParametrs.POINT_LEFT_WHEEL_X + xOffset, PrintParametrs.POINT_WHEEL_Y + yOffset, PrintParametrs.POINT_FRAME_UP_LEFT_X + xOffset, PrintParametrs.POINT_FRAME_UP_Y + yOffset));
        g2.draw(new Line2D.Float(PrintParametrs.POINT_FRAME_UP_LEFT_X + xOffset, PrintParametrs.POINT_FRAME_UP_Y + yOffset, PrintParametrs.POINT_FRAME_UP_RIGHT_X + xOffset, PrintParametrs.POINT_FRAME_UP_Y + yOffset));
        g2.draw(new Line2D.Float(PrintParametrs.POINT_FRAME_DOWN_LEFT_X + xOffset, PrintParametrs.POINT_WHEEL_Y + yOffset, PrintParametrs.POINT_FRAME_DOWN_RIGHT_X + xOffset, PrintParametrs.POINT_WHEEL_Y + yOffset));
        g2.draw(new Line2D.Float(PrintParametrs.POINT_FRAME_DOWN_RIGHT_X + xOffset, PrintParametrs.POINT_WHEEL_Y + yOffset, PrintParametrs.POINT_FRAME_UP_RIGHT_X + xOffset, PrintParametrs.POINT_FRAME_UP_Y + yOffset));
        g2.draw(new Line2D.Float(PrintParametrs.POINT_FRAME_UP_LEFT_X + xOffset, PrintParametrs.POINT_FRAME_UP_Y + yOffset, PrintParametrs.POINT_FRAME_DOWN_RIGHT_X + xOffset, PrintParametrs.POINT_WHEEL_Y + yOffset));
        g2.draw(new Line2D.Float(PrintParametrs.POINT_FRAME_UP_RIGHT_X + xOffset, PrintParametrs.POINT_FRAME_UP_Y + yOffset, PrintParametrs.POINT_RIGHT_WHEEL_X + xOffset, PrintParametrs.POINT_WHEEL_Y + yOffset));

    }
}
