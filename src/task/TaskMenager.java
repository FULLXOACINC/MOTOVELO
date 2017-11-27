package task;

import detail.ColorEnum;
import detail.FrameDetail;
import detail.WheelDetail;
import detail.YorkDetail;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by alex on 26.11.17.
 */
public class TaskMenager implements Runnable {
    TaskList taskList;
    private final int MAX_TASKS_COUNT = 4;
    Color[] col = {Color.CYAN, Color.green, Color.BLUE, Color.YELLOW};

    int index = 0;
    int id = 0;

    public TaskMenager(TaskList taskList) {
        this.taskList = taskList;

    }

    @Override
    public void run() {
        int sleepTime = 1000;

        while (true) {
            try {
                Thread.sleep(sleepTime);

                decrementTimer();
                removeFailedTasks();
                Thread.sleep(sleepTime / 2);
                addNewTask();


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void addNewTask() {
        if (taskList.getModels().size() <= MAX_TASKS_COUNT) {
            TaskView taskView = new TaskView();

            taskView.setBorder(BorderFactory.createLineBorder(Color.black));
            taskView.addElement(new WheelDetail(ColorEnum.getRandomColor(), 5, 30));
            taskView.addElement(new FrameDetail(col[new Random().nextInt(col.length)], 5));
            taskView.addElement(new YorkDetail(col[new Random().nextInt(col.length)], 5));
            Task task = new Task(id++, 10, 6, taskView);
            taskList.addTask(task);
        }
    }

    private void removeFailedTasks() {
        Iterator<Task> iterator = taskList.getModels().iterator();
        while (iterator.hasNext()) {
            Task md = iterator.next();
            if (md.isRemove()) {
                md.remove();
            }

        }
    }

    private void decrementTimer() {
        for (Task tasks : taskList.getModels()) {
            if (tasks.getTimer() >= 1)
                tasks.setTimer(tasks.getTimer() - 1);
        }
    }
}
