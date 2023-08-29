package imagenes.objetos;

import mvc.vistacontroladores.IDibujador;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Imagen implements IDibujador {
    private int alto;
    private int ancho;
    private int[][] pixeles;
    private PropertyChangeSupport observado;

    public Imagen(int w, int h) {
        ancho = w;
        alto = h;
        pixeles = new int[ancho][alto];
        observado = new PropertyChangeSupport(this);
    }

    @Override
    public void dibujar(Graphics g) {
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                g.setColor(new Color(pixeles[i][j]));
                g.drawLine(i,j,i,j);
            }
        }
    }

    public void imagen4x4() {
        // Primer cuadrado, parte superior izquierda BLACNO
        for (int i = 0; i < ancho/2; i++) {
            for (int j = 0; j < alto/2; j++) {
                pixeles[i][j] = 0x00FFFFFF;
            }
        }
        // Segundo cuadrado, parte superior derecha ROJO
        for (int i = ancho/2; i < ancho; i++) {
            for (int j = 0; j < alto/2; j++) {
                pixeles[i][j] = 0x00FF0000;
            }
        }

        // 3er cuadrado, parte inferior izquierda VERDE
        for (int i = 0; i < ancho/2; i++) {
            for (int j = alto/2; j < alto; j++) {
                pixeles[i][j] = 0x0000FF00;
            }
        }
        // 4to cuadrado, parte inferior derecha AZUL
        for (int i = ancho/2; i < ancho; i++) {
            for (int j = alto/2; j < alto; j++) {
                pixeles[i][j] = 0x000000FF;
            }
        }
    }

    public void addObserver(PropertyChangeListener listener) {
        observado.addPropertyChangeListener(listener);
    }

    public void achicar(int t) {
        int[][] nuevosPixeles = new int[ancho/t][alto/t];

        for (int i = 0; i < ancho; i+=t) {
            for (int j = 0; j < alto; j+=t) {
                nuevosPixeles[i/2][j/2] = pixeles[i][j];
            }
        }

        pixeles = nuevosPixeles;
        ancho = ancho/t;
        alto = alto /t;

        observado.firePropertyChange("IMAGEN",true, false);
    }
}
