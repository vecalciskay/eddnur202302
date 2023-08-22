package hanoi.objetos;

import java.util.Arrays;

public class Hanoi {
    private Torre[] torres;

    public Hanoi(int n) {
        torres = new Torre[3];
        torres[0] = new Torre(1, n);
        torres[1] = new Torre(2);
        torres[2] = new Torre(3);
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
    }

    public void resolver(int de, int a, int pp, int n) {
        if (n == 1) {
            mover(de, a);
            System.out.println(this);
            return;
        }
        resolver(de, pp,  a,  n-1);
        resolver(de,  a,  pp,  1);
        resolver(pp, a,  de,  n-1);
    }
}
