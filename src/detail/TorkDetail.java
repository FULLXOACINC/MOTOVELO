package detail;

import conveyor.ConveyorView;
import conveyor.ConveyorZoneView;

import java.awt.*;
import java.awt.geom.Line2D;

/**
 * Created by alex on 26.11.17.
 */
public class TorkDetail implements YorkView{
    @Override
    public void print(ConveyorZoneView view){
        Graphics g =view.getGraphics();
        Graphics2D g2 = (Graphics2D) g;
        Line2D lin = new Line2D.Float(100, 100, 250, 260);
        g2.draw(lin);
    }
}
