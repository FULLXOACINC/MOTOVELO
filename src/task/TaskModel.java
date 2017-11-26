package task;

/**
 * Created by alex on 26.11.17.
 */
public class TaskModel {
    private int points;
    private int summOfManey;
    private int timer;

    public TaskModel(int points, int summOfManey, int timer) {
        this.points = points;
        this.summOfManey = summOfManey;
        this.timer = timer;
    }

    public int getPoints() {
        return points;
    }

    public int getSummOfManey() {
        return summOfManey;
    }

    public int getTimer() {
        return timer;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setSummOfManey(int summOfManey) {
        this.summOfManey = summOfManey;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    @Override
    public String toString() {
        return "TaskModel{" +
                "points=" + points +
                ", summOfManey=" + summOfManey +
                ", timer=" + timer +
                '}';
    }
}
