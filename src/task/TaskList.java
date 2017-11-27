package task;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 26.11.17.
 */
public class TaskList extends JPanel {
    private List<Task> models;
    private final int TASK_COUNT = 4;

    public TaskList() {
        models = new ArrayList<Task>();
        setLayout(new GridLayout(1, 5, 5, 10));
        for (int index = 0; index < TASK_COUNT; index++) {
            TaskView task = new TaskView();
            task.setBorder(BorderFactory.createLineBorder(Color.black));
            models.add(new Task(0, 0, 0, task));
        }
        for (Task m : models) {
            add(m.getView());
        }

    }


    void addTask(Task addModel) {
        for (Task model : models) {
            if (model.getTimer() == 0) {
                model.clone(addModel);
                model.update();
                return;
            }
        }

    }

    public List<Task> getModels() {
        return models;
    }
}
