package task;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

/**
 * Created by alex on 26.11.17.
 */
public class TaskMenager implements Runnable {
    TaskList taskList;
    private final int MAX_TASKS_COUNT=5;
    Color[] col = {Color.CYAN,Color.green,Color.BLUE,Color.YELLOW,Color.RED};

    int index=0;
    int id=0;

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
                addNewTask();

                for (TaskModel tasks:taskList.getModels()) {
                    System.out.println(tasks);
                }
                System.out.println();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void addNewTask() {
        if(taskList.getModels().size()<MAX_TASKS_COUNT){
            JPanel panal = new JPanel();
            panal.setBackground(col[index]);
            index++;
            index%=col.length;
            TaskModel task = new TaskModel(id++,10,10);
            taskList.addTask(task,panal);
        }
    }

    private void removeFailedTasks() {
        Iterator<TaskModel> iterator = taskList.getModels().iterator();
        while (iterator.hasNext()){
            TaskModel md = iterator.next();
            if(md.getTimer()==0){
                int i = taskList.getModels().indexOf(md);

                System.out.println(i);
                taskList.remove(taskList.getTasks().get(i));
                taskList.getTasks().remove(taskList.getTasks().get(i));
                taskList.update();
                iterator.remove();
            }

        }
    }

    private void decrementTimer(){
        for (TaskModel tasks:taskList.getModels()) {
            tasks.setTimer(tasks.getTimer()-1);
        }
    }
}
