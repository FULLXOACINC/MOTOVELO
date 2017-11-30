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
import java.awt.event.ActionListener;
/**
 * Created by alex on 20.11.17.
 */
public class Main {
    private Conveyor conv;
    private Delivery delivery ;
    private Main() {
        JFrame frame = new JFrame("VELOMOTO");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Stock stock = new Stock();

        ActionListener nextAction = e -> {
            conv.next();
            if(conv.getModel().getCurrent().getModel().getZoneDetails().equals(delivery.getModel().getDetails()))
                return;
            delivery.getModel().setDetails(conv.getModel().getCurrent().getModel().getZoneDetails());
            delivery.getView().clear();
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

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();

        frame.setSize((int) width,350);
        frame.setFocusable(true);
        frame.setVisible(true);
        frame.setResizable(false);
    }


    public static void main(String[] args) {
        new Main();
    }
}
