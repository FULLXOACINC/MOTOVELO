package detail;

import java.awt.*;

/**
 * Created by alex on 27.11.17.
 */
public class WheelDetail implements WheelView{
    private Color color ;
    private int width;
    private int radius;

    public WheelDetail(Color color, int width, int radius) {
        this.color = color;
        this.width = width;
        this.radius = radius;
    }
    @Override
    public void print(Graphics graphics){
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setStroke(new BasicStroke(width));
        g2.setPaint(color);
        int diameter =radius*2;
        g2.drawOval(30 - radius, 70 - radius, diameter, diameter);
        g2.drawOval(120 - radius, 70 - radius, diameter, diameter);
    }
}
