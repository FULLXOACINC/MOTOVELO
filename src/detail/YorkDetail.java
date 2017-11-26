package detail;

import java.awt.*;
import java.awt.geom.Line2D;

/**
 * Created by alex on 26.11.17.
 */
public class YorkDetail implements YorkView{
    Color color ;
    int width;

    public YorkDetail(Color color, int width) {
        this.color = color;
        this.width = width;
    }

    @Override
    public void print(Graphics graphics){
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setStroke(new BasicStroke(width));
        g2.setPaint(color);
        g2.draw(new Line2D.Float(100, 30, 120, 40));
    }
}
