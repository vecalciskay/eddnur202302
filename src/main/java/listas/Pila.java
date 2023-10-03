package listas;

/**
 * El primero que entra es el ultimo que sale
 * @param <E>
 */
public class Pila<E> extends ListaDoble<E> {

    public Pila() {
        super();
    }

    public void push(E o) {
        insertar(o);
    }

    public E pop() {
        E o = eliminar(0);
        return o;
    }
}
