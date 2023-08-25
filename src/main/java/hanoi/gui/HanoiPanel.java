package hanoi.gui;

import hanoi.objetos.Hanoi;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HanoiPanel extends JPanel implements PropertyChangeListener {

    private Hanoi modelo;

    public HanoiPanel(Hanoi h) {
        modelo = h;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension (400,350);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        DibujoHanoi dibujo = new DibujoHanoi(modelo);
        dibujo.dibujar(g);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.repaint();
    }
}
