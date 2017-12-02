import pipeline.Pipeline;
import delivery.Delivery;
import detail.Stock;
import task.GameModel;
import task.GamePanel;
import task.TaskList;
import task.AddTaskManager;
import task.TaskManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by alex on 20.11.17.
 */
public class MainWindow {
    private Pipeline pipeline;
    private Delivery delivery;
    private final int COMPONENT_COUNT = 4;

    private MainWindow() {
        JFrame frame = new JFrame("VELOMOTO");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Stock stock = new Stock();

        ActionListener pipelineNextAction = e -> {
            pipeline.next();
            if (pipeline.getModel().getCurrent().getModel().getZoneDetails().equals(delivery.getModel().getDetails()))
                return;
            delivery.getModel().setDetails(pipeline.getModel().getCurrent().getModel().getZoneDetails());
            delivery.getDeliveryView().clear();
        };
        ActionListener deliveryNextAction = e -> {
            delivery.getModel().nextDetail();
            delivery.getDeliveryView().update(delivery.getModel().getCurrentDetail());
        };
        ActionListener deliveryAddAction = e -> {
            delivery.getDeliveryView().update(delivery.getModel().getCurrentDetail());
            pipeline.add(delivery.getModel().getCurrentDetail());
        };
        ActionListener deliveryPrevAction = e -> {
            delivery.getModel().prevDetail();
            delivery.getDeliveryView().update(delivery.getModel().getCurrentDetail());
        };

        pipeline = new Pipeline(stock, pipelineNextAction);
        delivery = new Delivery(deliveryAddAction, deliveryPrevAction, deliveryNextAction, pipeline.getModel().getCurrentZoneDetails());
        GameModel model = new GameModel(stock);
        GamePanel panel = new GamePanel(model);

        TaskList taskList = new TaskList();
        AddTaskManager addTaskManager = new AddTaskManager(taskList, pipeline.getModel());
        TaskManager taskManager = new TaskManager(taskList, panel);

        frame.setLayout(new GridLayout(COMPONENT_COUNT, 1, 0, 0));
        frame.add(panel);
        frame.add(taskList);
        frame.add(pipeline.getView());
        frame.add(delivery.getView());

        new Thread(addTaskManager).start();
        new Thread(taskManager).start();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double compression = 0.95;
        double width = screenSize.getWidth() * compression;

        frame.setSize((int) width, 350);
        frame.setFocusable(true);
        frame.setVisible(true);
        frame.setResizable(false);
    }


    public static void main(String[] args) {
        new MainWindow();
    }
}
