package listas;

import java.util.Iterator;

public class ListaDoble<E> implements Iterable<E> {
    private Nodo<E> raiz;
    private Nodo<E> cola;
    private int tamano;

    public ListaDoble() {
        raiz = null;
        cola = null;
    }

    public Nodo<E> getCola() {
        return cola;
    }

    public void setCola(Nodo<E> cola) {
        this.cola = cola;
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
        if (raiz != null) {
            raiz.setAnterior(nuevo);
        }
        raiz = nuevo;
        if (cola == null) {
            cola = raiz;
        }
        tamano++;
    }

    public E obtener(int posicion) {
        int contador = 0;
        for (E item : this) {
            if (contador == posicion) {
                return item;
            }
            contador++;
        }
        return null;
    }

    public void adicionar(E o) {
        Nodo<E> nuevo = new Nodo<>(o);
        nuevo.setAnterior(cola);
        if (cola != null) {
            cola.setSiguiente(nuevo);
        }
        cola = nuevo;
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

    public String toStringReversa() {
        StringBuilder resultado = new StringBuilder();
        Nodo<E> actual = cola;
        while(actual != null) {
            resultado.append(actual);
            actual = actual.getAnterior();
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
        return new IteradorListaDoble<>(raiz);
    }

    class IteradorListaDoble<E> implements Iterator<E> {
        private Nodo<E> actual;
        public IteradorListaDoble(Nodo<E> inicio) {
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
        private Nodo<E> anterior;

        public Nodo(E c) {
            contenido = c;
        }

        public Nodo<E> getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo<E> siguiente) {
            this.siguiente = siguiente;
        }

        public Nodo<E> getAnterior() {
            return anterior;
        }

        public void setAnterior(Nodo<E> anterior) {
            this.anterior = anterior;
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
