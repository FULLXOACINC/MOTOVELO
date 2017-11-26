package task;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 26.11.17.
 */
public class TaskList extends JPanel{
    private List<JPanel> tasks;
    private List<TaskModel> models;

    public TaskList() {
        tasks = new ArrayList<JPanel>();
        models = new ArrayList<TaskModel>();
      //  setLayout(new GridLayout(1,5,5,10));
    }

    void update(){
      //  for (JPanel task:tasks) {
            this.revalidate();
            this.repaint();

   //     }
    }

    void addTask(TaskModel model, JPanel panal){
        models.add(model);
        tasks.add(panal);
        add(panal);
        update();
    }

    public List<JPanel> getTasks() {
        return tasks;
    }

    public List<TaskModel> getModels() {
        return models;
    }
}
