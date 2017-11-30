import conveyor.Conveyor;
import delivery.Delivery;
import detail.Stock;
import task.GameModel;
import task.GamePanel;
import task.TaskList;
import task.AddTaskMenager;
import task.TaskMenager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    Conveyor conv;
    Delivery delivery;

    Main() {
        JFrame frame = new JFrame("VELOMOTO");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Stock stock = new Stock();
        delivery = null;
        ActionListener nextAction =new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                conv.next();
                delivery.getModel().setDetails(conv.getModel().getCurrent().getModel().getZoneDetails());
            }
        };
        conv = new Conveyor(stock,nextAction);
        delivery = new Delivery(conv);
        GameModel model = new GameModel(stock);
        GamePanel panel = new GamePanel(model);

        TaskList taskList = new TaskList();
        AddTaskMenager addTaskMenager = new AddTaskMenager(taskList, conv);
        TaskMenager taskMenager = new TaskMenager(taskList,panel);

        frame.setLayout(new GridLayout(4, 1, 0, 0));
        frame.add(panel);
        frame.add(taskList);
        frame.add(conv.getView());
        frame.add(delivery.getView());

        new Thread(addTaskMenager).start();
        new Thread(taskMenager).start();

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setFocusable(true);
        frame.setVisible(true);
        frame.setResizable(true);

    }


    public static void main(String[] args) {
        new Main();
    }
}
