package detail;

import java.awt.*;

/**
 * Created by alex on 29.11.17.
 */
public class Detail {
    DetailModel model;
    DetailView view;

    public Detail(int price, Color color, int width,DetailView view) {
        model = new DetailModel(price,color,width);
        this.view= view;
    }

    public DetailModel getModel() {
        return model;
    }

    public DetailView getView() {
        return view;
    }
}
