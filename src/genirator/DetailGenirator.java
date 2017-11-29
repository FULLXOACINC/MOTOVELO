package genirator;

import detail.Detail;
import detail.FrameDetail;
import detail.WheelDetail;
import detail.YorkDetail;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 29.11.17.
 */
public class DetailGenirator {

    public static List<Detail> get(String name ,int count) {
        List<Detail> details = new ArrayList<Detail>();
        switch (name) {
            case "York": {
                for (int index = 0; index < count; index++) {
                    Color color = ColorEnum.getRandomColor();
                    int width = WidthEnum.getRandomWidth();
                    details.add(new Detail(10, color, width, new YorkDetail(color, width)));
                }
                break;
            }
            case "Frame": {
                for (int index = 0; index < count; index++) {
                    Color color = ColorEnum.getRandomColor();
                    int width = WidthEnum.getRandomWidth();
                    details.add(new Detail(10, color, width, new FrameDetail(color, width)));
                }
                break;
            }
            case "Wheel": {
                for (int index = 0; index < count; index++) {
                    Color color = ColorEnum.getRandomColor();
                    int width = WidthEnum.getRandomWidth();
                    details.add(new Detail(10, color, width, new WheelDetail(color, width)));
                }
                break;
            }

        }
        return details;
    }
}
