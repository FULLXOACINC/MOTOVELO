import conveyor.Conveyor;
import delivery.Delivery;
import detail.Stock;
import task.TaskList;
import task.AddTaskMenager;
import task.TaskMenager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    Delivery delivery;
    private Conveyor conv;

    Main() {
        JFrame frame = new JFrame("VELOMOTO");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Delivery delivery = new Delivery();
        Stock stock = new Stock();
        conv = new Conveyor(stock);
        TaskList taskList = new TaskList();
        AddTaskMenager addTaskMenager = new AddTaskMenager(taskList, conv);
        TaskMenager taskMenager = new TaskMenager(taskList);
        new Thread(addTaskMenager).start();
        new Thread(taskMenager).start();

        frame.setLayout(new GridLayout(4, 1, 5, 10));
        frame.add(taskList);
        frame.add(conv.getView());

        JButton btn = new JButton("Add");
        btn.addActionListener(e -> conv.add());
        frame.add(btn);


        frame.setSize(760, 500);
        frame.setFocusable(true);
        frame.setVisible(true);
        frame.setResizable(true);
    }


    public static void main(String[] args) {
        new Main();
    }
}
