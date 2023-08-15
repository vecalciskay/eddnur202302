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
    private PropertyChangeSupport observado;

    public Cuadrado(int tamano, Color color) {
        this.tamano = tamano;
        this.color = color;
        x = 50;
        y = 50;
        observado = new PropertyChangeSupport(this);
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
        observado.firePropertyChange("CUAADRADO", antiguo, color);
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

    public void addObserver(PropertyChangeListener observador) {
        observado.addPropertyChangeListener(observador);
    }
}
