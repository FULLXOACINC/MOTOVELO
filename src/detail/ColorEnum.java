package detail;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Created by alex on 28.11.17.
 */
public enum ColorEnum {
        Red(Color.RED),
        Blue(Color.BLUE),
        Green(Color.GREEN),
        Gray(Color.GRAY),
        Orange(Color.ORANGE),
        Black(Color.BLACK),
        Yellow(Color.YELLOW),
        Pink(Color.PINK);


        private Color color;

        ColorEnum(Color color) {
                this.color = color;
        }

        private static ColorEnum[] colors =ColorEnum.values();

        private static Random random = new Random();

        public static Color getRandomColor(){
                return colors[random.nextInt(colors.length)].color;
        }

}
