package task;

import detail.DetailView;

/**
 * Created by alex on 26.11.17.
 */
class TaskModel {
    private int points;
    private int sumOfManey;
    private int timer;
    private TaskView view;


    TaskModel(int points, int summOfManey, int timer, TaskView view) {
        this.points = points;
        this.sumOfManey = summOfManey;
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
            view.removeAll();
            for (DetailView detail : view.getElements()) {
                detail.print(view.getGraphics());
            }
    }

    void remove() {
            view.removeAll();
            view.repaint();
            view.setEmpty();
        }

    boolean isRemove() {
        return (timer==0)&&(view.getElements().size()!=0);
    }

    void clone(TaskModel clone){
        this.points = clone.points;
        this.sumOfManey = clone.sumOfManey;
        this.timer = clone.timer;
        this.getView().setElements(clone.getView().getElements());
    }
}
