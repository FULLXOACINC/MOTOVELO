package task;

import pipeline.Pipeline;
import detail.Bike;
import pipeline.PipelineModel;


/**
 * Created by alex on 26.11.17.
 */
public class AddTaskManager implements Runnable {
    private TaskList taskList;
    private final int MAX_TASKS_COUNT = 4;
    private final int SLEEP_TIME = 4000;
    private PipelineModel model;
    private final int TIME=30;

    public AddTaskManager(TaskList taskList, PipelineModel model) {
        this.taskList = taskList;
        this.model = model;
    }

    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(SLEEP_TIME);
                addNewTask();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void addNewTask() {
        if (taskList.getModels().size() <= MAX_TASKS_COUNT) {
            TaskView taskView = new TaskView();
            Bike bike =model.getRandomBike();
            taskView.setBike(bike);
            Task task = new Task(10, bike.getSumm(), TIME, taskView);
            taskList.addTask(task);
        }
    }


}
