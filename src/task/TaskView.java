package task;

import detail.DetailView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 27.11.17.
 */
public class TaskView extends JPanel {
    private List<DetailView> elements;

    TaskView() {
        elements = new ArrayList<DetailView>();
    }

    void addElement(DetailView element) {
        elements.add(element);
    }

    List<DetailView> getElements() {
        return elements;
    }


    void setEmpty() {
        elements = new ArrayList<DetailView>();
    }

    void setElements(List<DetailView> elements) {
        this.elements = elements;
    }

    boolean isEmpty() {
        return elements.isEmpty();
    }

    void update() {
        removeAll();
        for (DetailView detail : elements) {
            detail.print(getGraphics());
        }
    }

    void remove() {
        removeAll();
        setEmpty();
        revalidate();
        repaint();

    }
}
