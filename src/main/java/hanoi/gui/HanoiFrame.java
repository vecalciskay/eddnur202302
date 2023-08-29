package hanoi.gui;

import hanoi.objetos.Hanoi;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HanoiFrame extends JFrame {
    private static Logger logger = LogManager.getRootLogger();
    private Hanoi modelo;
    public HanoiFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.getContentPane().setLayout(new BorderLayout());

        modelo = new Hanoi(4);
        HanoiPanel panel = new HanoiPanel(modelo);
        modelo.addObserver(panel);

        this.getContentPane().add(panel, BorderLayout.CENTER);

        JButton btn = new JButton("Resolver");
        btn.addActionListener(e -> {
            btnResolver_clicked();
        });

        this.getContentPane().add(btn, BorderLayout.SOUTH);
        this.setVisible(true);
        this.pack();
    }

    private void btnResolver_clicked() {
        logger.info("Hizo clic en resolver");
        Thread t = new Thread(new Runnable() {
           public void run() {
               try {
                   modelo.resolver(0,2,1,4);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        });

        t.start();
    }

    public static void main(String[] args) {
        new HanoiFrame();
    }
}
