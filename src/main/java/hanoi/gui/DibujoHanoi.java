package hanoi.gui;

import hanoi.objetos.Anillo;
import hanoi.objetos.Hanoi;
import hanoi.objetos.Torre;
import mvc.vistacontroladores.IDibujador;

import java.awt.*;

public class DibujoHanoi implements IDibujador {
    private Hanoi modelo;

    public DibujoHanoi(Hanoi h) {
        modelo = h;
    }
    @Override
    public void dibujar(Graphics g) {
        // base
        g.fillRect(0,300,300,10);

        g.fillRect(50,100,10, 200);
        g.fillRect(150,100,10, 200);
        g.fillRect(250,100,10, 200);

        int numTorre = 0;
        for(Torre t : modelo.getTorres()) {

            int numAnillo = 1;
            for (Anillo a : t.getAnillos()) {
                g.fillRect(50 + 100*numTorre, 300 - numAnillo * 20,
                        20 * a.getTamano(), 10);
                numAnillo++;
            }
            numTorre++;
        }
    }
}
