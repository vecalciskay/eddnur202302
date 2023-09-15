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

    public void aplicarMatriz(MatrizTransformacion m) {
        int[][] nuevosPixeles = new int[ancho][alto];

        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                Vector2 entrada = new Vector2(i,j);
                Vector2 salida = m.aplicarMatriz(entrada);
                if ((int)salida.getX() >= 0 &&
                        (int)salida.getX() < ancho &&
                        (int)salida.getY() >= 0 &&
                        (int)salida.getY() < alto) {
                    nuevosPixeles[(int)salida.getX()][(int)salida.getY()] =
                            pixeles[i][j];
                }
            }
        }
        pixeles = nuevosPixeles;
        observado.firePropertyChange("IMAGEN",true, false);
    }

    public int getAlto() {
        return alto;
    }

    public int getAncho() {
        return ancho;
    }

    public int[][] getPixeles() {
        return pixeles;
    }

    public void punto(int x, int y, int tamano) {

        for (int i = x - tamano/2; i < x + tamano / 2; i++) {
            for (int j = y - tamano/2; j < y + tamano/2; j++) {
                if (i >= 0 && i < ancho &&
                j >= 0 && j < alto) {
                    pixeles[i][j] = 0;
                }
            }
        }
        observado.firePropertyChange("IMAGEN",true, false);
    }

    public void linea(int x1, int y1, int x2, int y2) {
        /**
         * int step;
         *         if (x1 > x2) {
         *             step = -1;
         *         } else {
         *             step = 1;
         *         }
         */

        // ---- Si son lineas horizontales
        if (Math.abs(x2 - x1) > Math.abs(y2 - y1)) {
            int stepX = (x1 > x2 ? -1 : 1);
            int stepY = (y1 > y2 ? -1 : 1);
            double ratio = (double)Math.abs(y2 - y1) / (double)Math.abs(x2 - x1);
            int x = 0;
            for (int i = x1; i != x2; i += stepX) {

                pixeles[i][y1 + stepY * (int)(x * ratio)] = 0;
                x++;
            }
        }
        if (Math.abs(x2 - x1) <= Math.abs(y2 - y1)) {
            int stepX = (x1 > x2 ? -1 : 1);
            int stepY = (y1 > y2 ? -1 : 1);
            double ratio = (double)Math.abs(x2 - x1) / (double)Math.abs(y2 - y1);
            int y = 0;
            for (int j = y1; j != y2; j += stepY) {
                pixeles[x1 + stepX * (int)(y * ratio)][j] = 0;
                y++;
            }
        }
        observado.firePropertyChange("IMAGEN",true, false);
    }
}
