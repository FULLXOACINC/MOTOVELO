import conveyor.Conveyor;
import delivery.Delivery;
import task.TaskList;
import task.TaskMenager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    Delivery delivery;
    Conveyor conv;
    TaskMenager taskMenager;
    TaskList taskList;

    Main(){
        JFrame frame = new JFrame("VELOMOTO");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Delivery delivery = new Delivery();
        Conveyor conv = new Conveyor();
        taskList = new TaskList();
        TaskMenager taskMenager = new TaskMenager(taskList);
        new Thread(taskMenager).start();



        frame.add(taskList,BorderLayout.NORTH);
        frame.add(conv.getView(),BorderLayout.CENTER);

        JButton btn = new JButton("Next");
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                conv.next();
            }
        });
        frame.add(btn,BorderLayout.SOUTH);

        frame.setSize(640,250);
        frame.setFocusable(true);
        frame.setVisible(true);
        frame.setResizable(true);
    }

    private JPanel getDelivery() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.GREEN);
        return panel;
    }

    private JPanel getConveyorPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        return panel;
    }

    public static void main(String[] args) {
        new Main();
    }
}
