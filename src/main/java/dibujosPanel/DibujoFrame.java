package dibujosPanel;

import javax.swing.*;
import java.awt.*;

/**
 * En este frame solamente se coloca un panel DibujoPanel y debajo se
 * coloca un boton para guardar la imagen del DibujoPanel en un
 * archivo.
 */
public class DibujoFrame extends JFrame {
    private DibujoPanel dibujoPanel;
    public DibujoFrame() {
        super("Dibujo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dibujoPanel = new DibujoPanel();
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add( dibujoPanel, BorderLayout.CENTER);
        JButton botonGuardar = new JButton("Guardar");
        botonGuardar.addActionListener(e -> guardar());
        add(botonGuardar, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new DibujoFrame();
    }

    private void guardar() {
        dibujoPanel.guardarArchivo("e:/Vladimir/dibujo001.png");
    }
}
