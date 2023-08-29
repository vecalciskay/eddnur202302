package hanoi.objetos;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Arrays;

public class Hanoi {
    private Torre[] torres;
    private PropertyChangeSupport observado;

    public Hanoi(int n) {
        torres = new Torre[3];
        torres[0] = new Torre(1, n);
        torres[1] = new Torre(2);
        torres[2] = new Torre(3);
        observado = new PropertyChangeSupport(this);
    }
    public void addObserver(PropertyChangeListener observador) {
        observado.addPropertyChangeListener(observador);
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        for (Torre t:
             torres) {
            resultado.append(t);
        }
        resultado.append("\n");
        return resultado.toString();
    }

    public void mover(int origen, int destino) {
        Anillo a = torres[origen].sacar();
        torres[destino].colocar(a);
        observado.firePropertyChange("HANOI", true, false);
    }

    public void resolver(int de, int a, int pp, int n) throws InterruptedException {
        if (n == 1) {
            mover(de, a);
            Thread.sleep(500);
            return;
        }
        resolver(de, pp,  a,  n-1);
        resolver(de,  a,  pp,  1);
        resolver(pp, a,  de,  n-1);
    }

    public Torre[] getTorres() {
        return torres;
    }
}
