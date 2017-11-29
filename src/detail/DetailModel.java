package detail;

import java.awt.*;

/**
 * Created by alex on 29.11.17.
 */
public class DetailModel {
    private int price;
    private int width;
    private Color color;

    public DetailModel(int price, Color color, int width) {
        this.price = price;
        this.color = color;
        this.width = width;
    }

    public int getPrice() {
        return price;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetailModel that = (DetailModel) o;

        return width == that.width && (color != null ? color.equals(that.color) : that.color == null);
    }

    @Override
    public int hashCode() {
        int result = price;
        result = 31 * result + width;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }
}
