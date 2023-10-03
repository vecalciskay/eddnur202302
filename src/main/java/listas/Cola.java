package listas;

/**
 * El primero que entra es el primero que sale
 * @param <E>
 */
public class Cola<E> extends ListaDoble<E>{
    public Cola() {
        super();
    }

    public void push(E o) {
        insertar(o);
    }

    public E pull() {
        E o = eliminar(tamano - 1);
        return o;
    }
}
