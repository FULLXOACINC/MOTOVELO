package task;

/**
 * Created by alex on 29.11.17.
 */
public class TaskMenager implements Runnable {
    private TaskList taskList;

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

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void removeFailedTasks() {
        for (Task model : taskList.getModels()) {
            if (model.isRemove()) {
                model.remove();
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
