package genirator;

import java.awt.*;
import java.util.Random;

/**
 * Created by alex on 29.11.17.
 */
public enum WidthEnum {
    Two(2),
    Five(5),
    Seven(7),
    Ten(10);


    private int width;

    WidthEnum(int width) {
        this.width = width;
    }

    private static WidthEnum[] widths = WidthEnum.values();

    private static Random random = new Random();

    public static int getRandomWidth() {
        return widths[random.nextInt(widths.length)].width;
    }
}
