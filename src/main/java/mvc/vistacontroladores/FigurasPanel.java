package mvc.vistacontroladores;

import mvc.modelos.Cuadrado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class FigurasPanel extends JPanel
        implements PropertyChangeListener, MouseListener, MouseMotionListener {

    private Cuadrado modelo;

    public FigurasPanel(Cuadrado c) {
        modelo = c;
        modelo.addObserver(this);

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
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

    /**
     * Si no esta seleccionado, entonces ver si hemos hecho click
     * dentro del cuadrado para seleccionarlo.
     * Se esta seleccionado, entonces guardar estas posiciones nuevas
     * y lanzar una animacion para mover el cuadrado desde sus posiciones
     * actuales a estas que estamos guardando durante 5 segundos.
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        if (!modelo.isSeleccionado()) {

            if (modelo.posicionDentroDelCuadrado(x, y)) {
                modelo.setSeleccionado(true);
                modelo.clickOffset(x, y);
            }
        } else {
            modelo.setPosicionFinal(x, y);
            Thread t = new Thread(() -> {
                modelo.animacion(30, 5000);
            });
            t.start();
        }
    }

    /**
     * Una vez que conocemos la posicion
     * testeamos si la posicion esta dentro del cuadrado
     * Si es el caso marcamos el cuadrado como seleccionado
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        if ( modelo.posicionDentroDelCuadrado(x,y)) {
            modelo.setSeleccionado(true);
            modelo.clickOffset(x,y);
        }
    }

    /**
     * Deseleccionar cualquier cuadrado seleccionado
     * @param e
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        //modelo.setSeleccionado(false);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // No utilizado
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // No utilizado
    }

    /**
     * Si el cuadrado esta selccionado entonces se debe
     * mover el cuadrado a la posicion indicada por el evento
     * @param e
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if (modelo.isSeleccionado()) {
            modelo.mover(x, y);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // No utilizado
    }
}
