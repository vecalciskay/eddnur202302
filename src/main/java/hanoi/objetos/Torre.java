package hanoi.objetos;

import java.util.Stack;

public class Torre {
    private final Stack<Anillo> anillos;
    private int id;

    public Torre(int id) {
        anillos = new Stack<>();
        this.id = id;
    }

    /**
     *
     * @param id
     * @param n Esta es la cantidad de anillos en la torre inicialmente
     */
    public Torre(int id, int n) {
        anillos = new Stack<>();
        this.id = id;

        for (int i = 0; i < n; i++) {
            Anillo a = new Anillo(n-i);
            anillos.push(a);
        }

    }

    public Anillo sacar() {
        return anillos.pop();
    }

    public void colocar(Anillo a) {
        anillos.push(a);
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();

        resultado.append("[").append(id).append("]|-");
        for (Anillo a :
                anillos) {
            resultado.append(a).append("-");
        }
        resultado.append("\n");

        return resultado.toString();
    }
}
