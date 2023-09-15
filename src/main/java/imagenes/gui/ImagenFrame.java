package imagenes.gui;
import imagenes.objetos.Imagen;
import imagenes.objetos.MatrizTransformacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImagenFrame extends JFrame {
    private Imagen modelo;
    public ImagenFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.getContentPane().setLayout(new BorderLayout());

        modelo = new Imagen(400,400);
        modelo.imagen4x4();

        ImagenPanel panel = new ImagenPanel(modelo);
        modelo.addObserver(panel);
        this.getContentPane().add(panel, BorderLayout.CENTER);

        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("Operaciones");
        JMenuItem item = new JMenuItem("Achicar");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAchicar_clicked();
            }
        });
        menu.add(item);

        item = new JMenuItem("Matriz de Transformacion");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnTransformacion_clicked();
            }
        });
        menu.add(item);

        item = new JMenuItem("Linea horizontal");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnLineaHorizontal_clicked();
            }
        });
        menu.add(item);

        item = new JMenuItem("Linea vertical");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnLineaVertical_clicked();
            }
        });
        menu.add(item);

        item = new JMenuItem("Linea diagonal Horizontal");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnLineaDiagonalH_clicked();
            }
        });
        menu.add(item);

        item = new JMenuItem("Linea diagonal Vertical");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnLineaDiagonalV_clicked();
            }
        });
        menu.add(item);

        bar.add(menu);
        this.setJMenuBar(bar);

        this.setVisible(true);
        this.pack();
    }

    private void btnLineaDiagonalV_clicked() {
        // lineas hacia derecha
        modelo.linea(50,50,100,200);
        modelo.linea(100,200,150,50);

        modelo.linea(200, 250, 150, 400);
    }
    private void btnLineaDiagonalH_clicked() {
        // lineas hacia abajo
        modelo.linea(50,50,250,100);
        modelo.linea(250,100,50,150);

        // linea hacia arriba
        modelo.linea(50,250,300,200);
    }
    private void btnLineaVertical_clicked() {
        modelo.linea(50,100,50,200);
    }

    private void btnLineaHorizontal_clicked() {
        modelo.linea(300,100, 200,100);

        modelo.linea(100,150, 200,150);


    }

    private void btnTransformacion_clicked() {
        MatrizTransformacion m = new MatrizTransformacion();
        m.traslacion(modelo.getAncho(),0);
        m.rotacion(-90);
        modelo.aplicarMatriz(m);
    }

    private void btnAchicar_clicked() {
        modelo.achicar(2);
    }


    public static void main(String[] args) {
        new ImagenFrame();
    }
}
