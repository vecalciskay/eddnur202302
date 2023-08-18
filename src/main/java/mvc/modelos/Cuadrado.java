package mvc.modelos;

import mvc.vistacontroladores.FigurasPanel;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Cuadrado {
    private int tamano;
    private Color color;
    private int x;
    private int y;
    private int offsetX;
    private int offsetY;
    private boolean seleccionado;
    private PropertyChangeSupport observado;
    private int finalX;
    private int finalY;

    public Cuadrado(int tamano, Color color) {
        this.tamano = tamano;
        this.color = color;
        x = 50;
        y = 50;
        observado = new PropertyChangeSupport(this);
        seleccionado = false;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        Color antiguo = this.color;
        this.color = color;
        observado.firePropertyChange("COLOR", antiguo, color);
    }

    /**
     * Este mover toma en cuenta el offset dado al momento
     * de seleccionar el cuadrado
     * @param x
     * @param y
     */
    public void mover(int x, int y) {
        int oldX = this.x;
        this.x = x - offsetX;
        this.y = y - offsetY;
        observado.firePropertyChange("POSICION",oldX, this.x);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    public void addObserver(PropertyChangeListener observador) {
        observado.addPropertyChangeListener(observador);
    }

    /**
     *
     * @param x0
     * @param y0
     * @return
     */
    public boolean posicionDentroDelCuadrado(int x0, int y0) {
        if (x0 > x && x0 < (x+tamano) &&
                y0 > y && y0 < (y+tamano))
            return true;
        return false;
    }

    public void clickOffset(int x0, int y0) {
        offsetX = x0 - x;
        offsetY = y0 - y;
    }

    public void animacion(int numeroPasos, int milisegundos) {
        double stepX = Math.abs((finalX - x) / numeroPasos);
        double stepY = Math.abs((finalY - y) / numeroPasos);
        int timeToSleep = milisegundos / numeroPasos;
        int x0 = x;
        int y0 = y;
        int sentidoX = (finalX > x) ? 1 : -1;
        int sentidoY = (finalY > y) ? 1 : -1;
        for (int i = 0; i < numeroPasos; i++) {

            int npX = (int)((double)x0 + sentidoX*(double)i*stepX);
            int npY = (int)((double)y0 + sentidoY*(double)i*stepY);

            mover(npX, npY);

            try {
                Thread.sleep(timeToSleep);
            } catch(Exception q) {
                ;
            }
        }
    }

    public void setPosicionFinal(int x, int y) {
        this.finalX = x;
        this.finalY = y;
    }
}
