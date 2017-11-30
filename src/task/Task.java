package task;

/**
 * Created by alex on 26.11.17.
 */
class Task {
    private int points;
    private int sumOfMoney;
    private int timer;
    private TaskView view;


    Task(int points, int sumOfMoney, int timer, TaskView view) {
        this.points = points;
        this.sumOfMoney = sumOfMoney;
        this.timer = timer;
        this.view = view;
    }

    int getTimer() {
        return timer;
    }

    void setTimer(int timer) {
        this.timer = timer;
    }


    TaskView getView() {
        return view;
    }

    void update() {
        view.update();
    }

    void updateInformation(){
        view.setLable(points,timer,sumOfMoney);
    }

    void remove() {
        timer=0;
        view.remove();
    }

    boolean isRemove() {
        return (timer == 0) && (!view.isEmpty());
    }

    void clone(Task clone) {
        this.points = clone.points;
        this.sumOfMoney = clone.sumOfMoney;
        this.timer = clone.timer;
        this.getView().setElements(clone.getView().getElements());
    }
}
