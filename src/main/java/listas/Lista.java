package listas;

public class Lista {
    private Nodo raiz;

    public Lista() {
        raiz = null;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public void insertar(Object o) {
        Nodo nuevo = new Nodo(o);
        nuevo.setSiguiente(raiz);
        raiz = nuevo;
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        Nodo actual = raiz;
        while(actual != null) {
            resultado.append(actual);
            actual = actual.getSiguiente();
        }
        return resultado.toString();
    }

    static class Nodo {
        private Object contenido;
        private Nodo siguiente;

        public Nodo(Object c) {
            contenido = c;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }

        public Object getContenido() {
            return contenido;
        }

        @Override
        public String toString() {
            return "[" + contenido.toString() + "]-->";
        }
    }
}
