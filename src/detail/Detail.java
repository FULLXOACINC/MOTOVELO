package detail;

import conveyor.ConveyorZoneView;

import javax.swing.*;
import java.awt.*;

/**
 * Created by alex on 26.11.17.
 */
public class Detail implements FrameView{
    @Override
    public void print(ConveyorZoneView view){
        Graphics g =view.getGraphics();
        g.setColor(Color.red);
        g.fillRect(10,10,100,100);

    }
}
