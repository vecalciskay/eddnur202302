package mvc.vistacontroladores;

import mvc.modelos.Cuadrado;

import java.awt.*;

public class DibujoCuadrado implements IDibujador{
    private Cuadrado modelo;

    public DibujoCuadrado(Cuadrado c) {
        modelo = c;
    }

    public void dibujar(Graphics g) {

        g.setColor(modelo.getColor());
        g.fillRect(modelo.getX(),modelo.getY(),
                modelo.getTamano(), modelo.getTamano());

        if (modelo.isSeleccionado()) {
            g.setColor(Color.black);
            g.drawRect(modelo.getX(),modelo.getY(),
                    modelo.getTamano(), modelo.getTamano());
        }
    }
}
