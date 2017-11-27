package task;

import detail.DetailView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 27.11.17.
 */
public class TaskView extends JPanel{
    private List<DetailView> elements;

    public TaskView() {
        elements = new ArrayList<DetailView>();
    }
    void addElement(DetailView element){
        elements.add(element);
    }

    public List<DetailView> getElements() {
        return elements;
    }


    public void setEmpty() {
        elements = new ArrayList<DetailView>();
    }

    public void setElements(List<DetailView> elements) {
        this.elements = elements;
    }
}
