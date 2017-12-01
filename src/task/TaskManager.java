package task;

import detail.Bike;

/**
 * Created by alex on 29.11.17.
 */
public class TaskManager implements Runnable {
    private TaskList taskList;
    private GamePanel panel;
    private final int SLEEP_TIME = 1000;

    public TaskManager(TaskList taskList, GamePanel panel) {
        this.taskList = taskList;
        this.panel = panel;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(SLEEP_TIME);
                decrementTimer();
                panel.getModel().incrementTime();
                cheakComplitedTask();
                removeFailedTasks();
                panel.update();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void cheakComplitedTask() {
        for (Task model : taskList.getModels()) {
            for (Bike bike:panel.getModel().getStock().getBikes()){
                if (model.getView().getBike().equals(bike)) {
                    panel.getModel().complited(model.getPoints());
                    panel.getModel().getStock().getBikes().remove(bike);
                    model.remove();
                    break;
                }
            }

        }
    }

    private void removeFailedTasks() {
        for (Task model : taskList.getModels()) {
            if (model.isRemove()) {
                panel.getModel().failed(model.getPoints());
                model.remove();
            }

        }
    }

    private void decrementTimer() {
        for (Task tasks : taskList.getModels()) {
            if (tasks.getTimer() >= 1){
                tasks.setTimer(tasks.getTimer() - 1);
                tasks.updateInformation();
            }

        }
    }
}
