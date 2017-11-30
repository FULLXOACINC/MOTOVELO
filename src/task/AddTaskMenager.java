package task;

import conveyor.Conveyor;
import javax.swing.*;
import java.awt.*;


/**
 * Created by alex on 26.11.17.
 */
public class AddTaskMenager implements Runnable {
    private TaskList taskList;
    private final int MAX_TASKS_COUNT = 4;
    private int id = 0;
    private Conveyor conv;

    public AddTaskMenager(TaskList taskList, Conveyor conv) {
        this.taskList = taskList;
        this.conv = conv;
    }

    @Override
    public void run() {
        int sleepTime = 4000;

        while (true) {
            try {
                Thread.sleep(sleepTime);
                addNewTask();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void addNewTask() {
        if (taskList.getModels().size() <= MAX_TASKS_COUNT) {
            TaskView taskView = new TaskView();

            taskView.setBike(conv.getModel().getRandomBike());
            Task task = new Task(id++, 10, 20, taskView);
            taskList.addTask(task);
        }
    }


}
