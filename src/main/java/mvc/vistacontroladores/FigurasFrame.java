package mvc.vistacontroladores;

import mvc.modelos.Cuadrado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FigurasFrame extends JFrame {

    private Cuadrado modelo;

    public FigurasFrame() {
        init();
    }

    private void init() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.getContentPane().setLayout(new BorderLayout());

        modelo = new Cuadrado(100, Color.red);
        FigurasPanel panel = new FigurasPanel(modelo);
        this.getContentPane().add(panel, BorderLayout.CENTER);

        JButton btn = new JButton("Verde");
        btn.addActionListener(e -> btnVerde_clicked());

        this.getContentPane().add(btn, BorderLayout.SOUTH);

        this.setVisible(true);
        this.pack();
    }

    private void btnVerde_clicked() {
        modelo.setColor(Color.green);
    }

    public static void main(String[] args) {
        new FigurasFrame();
    }
}
