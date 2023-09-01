package imagenes.gui;

import imagenes.objetos.Imagen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ImagenPanel extends JPanel implements PropertyChangeListener, MouseMotionListener {
    private Imagen modelo;
    public ImagenPanel(Imagen img) {

        modelo = img;
        this.addMouseMotionListener(this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800,600);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        modelo.dibujar(g);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        modelo.punto(e.getX(), e.getY(), 20);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
