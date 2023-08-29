package imagenes.gui;
import imagenes.objetos.Imagen;

import javax.swing.*;
import java.awt.*;

public class ImagenFrame extends JFrame {
    private Imagen modelo;
    public ImagenFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.getContentPane().setLayout(new BorderLayout());

        modelo = new Imagen(600,400);
        modelo.imagen4x4();
        ImagenPanel panel = new ImagenPanel(modelo);
        modelo.addObserver(panel);
        this.getContentPane().add(panel, BorderLayout.CENTER);


        JButton btn = new JButton("Achicar");
        btn.addActionListener(e -> {
            btnAchicar_clicked();
        });

        this.getContentPane().add(btn, BorderLayout.SOUTH);

        this.setVisible(true);
        this.pack();
    }

    private void btnAchicar_clicked() {
        modelo.achicar(2);
    }


    public static void main(String[] args) {
        new ImagenFrame();
    }
}
