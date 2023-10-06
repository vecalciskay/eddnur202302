package listas;

public class ListaDobleOrdenada<E> extends ListaDoble<E> {
    public ListaDobleOrdenada() {
        super();
    }

    @Override
    public void insertar(E o) {
        if (!(o instanceof Comparable) || tamano == 0) {
            super.insertar(o);
            return;
        }

        E contenidoRaiz = raiz.getContenido();
        Comparable<E> obj1 = (Comparable)o;

        if (obj1.compareTo(contenidoRaiz) < 0) {
            super.insertar(o);
            return;
        }

        Nodo<E> actual = raiz;
        while(actual.getSiguiente() != null &&
                obj1.compareTo(actual.getSiguiente().getContenido()) >= 1) {
            actual = actual.getSiguiente();
        }

        Nodo<E> nuevo = new Nodo(o);
        nuevo.setSiguiente(actual.getSiguiente());
        nuevo.setAnterior(actual);

        if (actual.getSiguiente() != null) {
            actual.getSiguiente().setAnterior(nuevo);
        }
        actual.setSiguiente(nuevo);
        tamano++;
    }

    @Override
    public E buscar(E o) {
        if (!(o instanceof Comparable)){
            return super.buscar(o);
        }

        if (tamano == 0)
            return null;

        return busquedaDicotomica(0,tamano-1, o);
    }

    private E busquedaDicotomica(int primero, int ultimo, E o) {

        int medio = primero + (ultimo - primero) / 2;
        E obj = obtener(medio);
        Comparable<E> objComparable = (Comparable)o;
        if (objComparable.compareTo(obj) > 0) {
            return busquedaDicotomica(medio, ultimo, o);
        }
        if (objComparable.compareTo(obj) < 0) {
            return busquedaDicotomica(primero, medio, o);
        }
        return obj;
    }
}
