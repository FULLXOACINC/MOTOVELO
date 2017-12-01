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
        time = 0;
        xFactor = 1;
        failed = 0;
        points = 0;
    }

    int getTime() {
        return time;
    }

    int getxFactor() {
        return xFactor;
    }

    int getFailed() {
        return failed;
    }

    int getBikeCount() {
        return stock.getBikes().size();
    }

    void incrementTime() {
        time++;
    }

    void complited(int points) {
        this.points += points * xFactor;
        xFactor++;
    }

    void failed(int points) {
        xFactor = 1;
        failed++;
        this.points -= points;
    }

    Stock getStock() {
        return stock;
    }

    int getPoints() {
        return points;
    }
}
