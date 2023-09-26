package listas;

import java.util.Iterator;

public class ListaGenerica<E> implements Iterable<E> {
    private Nodo<E> raiz;
    private int tamano;

    public ListaGenerica() {
        raiz = null;
    }

    public Nodo<E> getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo<E> raiz) {
        this.raiz = raiz;
    }

    public void insertar(E o) {
        Nodo<E> nuevo = new Nodo<>(o);
        nuevo.setSiguiente(raiz);
        raiz = nuevo;
        tamano++;
    }

    public void adicionar(E o) {
        Nodo<E> nuevo = new Nodo<>(o);
        if (tamano == 0){
            insertar(o);
            return;
        }

        Nodo<E> actual = raiz;
        while(actual.getSiguiente() != null) {
            actual = actual.getSiguiente() ;

        }
        actual.setSiguiente(nuevo);
        tamano++;
    }

    public void eliminar (int posicion){
        if (posicion>(tamano-1)){
            throw new IllegalArgumentException("la posicion esa fuera de la lista");
        }
        if (posicion==0){
            raiz=raiz.getSiguiente();
            tamano--;
            return;
        }
        int resultado = 0;
        Nodo<E> actual = raiz;
        while(resultado < (posicion-1)) {
            actual = actual.getSiguiente();
            resultado++;
        }
        actual.setSiguiente(actual.getSiguiente().getSiguiente());
        tamano--;
    }


    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        Nodo<E> actual = raiz;
        while(actual != null) {
            resultado.append(actual);
            actual = actual.getSiguiente();
        }
        return resultado.toString();
    }

    public int tamano(){

        return tamano;
        /*int resultado = 0;
        Nodo<E> actual = raiz;
        while(actual != null) {
            actual = actual.getSiguiente();
            resultado++;
        }
        return resultado;*/
    }

    @Override
    public Iterator<E> iterator() {
        return new IteradorListaGenerica<>(raiz);
    }

    class IteradorListaGenerica<E> implements Iterator<E> {
        private Nodo<E> actual;
        public IteradorListaGenerica(Nodo<E> inicio) {
            actual = inicio;
        }

        @Override
        public boolean hasNext() {
            return actual != null;
        }

        @Override
        public E next() {
            E o = actual.getContenido();
            actual = actual.getSiguiente();
            return o;
        }
    }

    static class Nodo<E> {
        private E contenido;
        private Nodo<E> siguiente;

        public Nodo(E c) {
            contenido = c;
        }

        public Nodo<E> getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo<E> siguiente) {
            this.siguiente = siguiente;
        }

        public E getContenido() {
            return contenido;
        }

        @Override
        public String toString() {
            return "[" + contenido.toString() + "]-->";
        }
    }
}
