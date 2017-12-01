package genirator;

import detail.Detail;
import detail.FrameDetail;
import detail.WheelDetail;
import detail.YorkDetail;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by alex on 29.11.17.
 */
public class DetailGenirator {
    private static final Color[] COLORS = {Color.RED, Color.BLUE, Color.GREEN, Color.GRAY, Color.ORANGE, Color.BLACK, Color.YELLOW, Color.PINK};
    private static final int WIDTH = 5;
    private static final int PRICE = 10;

    public static List<Detail> get(String name, int count) {
        List<Detail> details = new ArrayList<Detail>();

        switch (name) {
            case "York": {
                for (int index = 0; index < count; index++) {
                    Color color = COLORS[new Random().nextInt(COLORS.length)];
                    details.add(new Detail(new Random().nextInt(PRICE) + 1, color, WIDTH, new YorkDetail(color, WIDTH)));
                }
                break;
            }
            case "Frame": {
                for (int index = 0; index < count; index++) {
                    Color color = COLORS[new Random().nextInt(COLORS.length)];
                    details.add(new Detail(new Random().nextInt(PRICE) + 1, color, WIDTH, new FrameDetail(color, WIDTH)));
                }
                break;
            }
            case "Wheel": {
                for (int index = 0; index < count; index++) {
                    Color color = COLORS[new Random().nextInt(COLORS.length)];
                    details.add(new Detail(new Random().nextInt(PRICE) + 1, color, WIDTH, new WheelDetail(color, WIDTH)));
                }
                break;
            }

        }
        return details;
    }
}
