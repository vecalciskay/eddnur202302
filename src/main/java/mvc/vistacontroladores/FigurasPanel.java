package mvc.vistacontroladores;

import mvc.modelos.Cuadrado;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class FigurasPanel extends JPanel implements PropertyChangeListener {

    private Cuadrado modelo;

    public FigurasPanel(Cuadrado c) {
        modelo = c;
        modelo.addObserver(this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500,500);
    }

    /**
     * En algun momento el panel debe conocer el modelo
     * y debe saber como hacer para dibujarlo
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // opcion A
        //modelo.dibujar(g);

        // opcion B
        //g.drawRect(modelo.getX(),modelo.getY(),
        //        modelo.getTamano(), modelo.getTamano());

        // opcion C
        IDibujador dibujo = new DibujoCuadrado(modelo);
        dibujo.dibujar(g);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }
}
