package task;

import detail.Stock;

/**
 * Created by alex on 29.11.17.
 */
public class GameModel {
    private int time;
    private int xFactor;
    private int failed;
    private int points;
    private Stock stock;

    public GameModel(Stock stock) {
        this.stock = stock;
        time=0;
        xFactor=1;
        failed=0;
        points=0;
    }

    public int getTime() {
        return time;
    }

    public int getxFactor() {
        return xFactor;
    }

    public int getFailed() {
        return failed;
    }

    public int getBikeCount(){
        return  stock.getBikes().size();
    }

    public void incrementTime(){
        time++;
    }

    public void complited(int points){
        this.points+=points*xFactor;
        xFactor++;
    }

    public void failed(int points){
        xFactor=1;
        failed++;
        this.points-=points;
    }

    public Stock getStock() {
        return stock;
    }

    public int getPoints() {
        return points;
    }
}
