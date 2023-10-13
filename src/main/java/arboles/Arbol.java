package arboles;

import listas.ListaDoble;

import java.util.Objects;

public class Arbol<E> {

    private Nodo<E> raiz;

    public void insertar(String id, E o, String idpadre) {

    }

    class Nodo<E> {
        private String id;
        private E contenido;
        private ListaDoble<Nodo<E>> hijos;

        public Nodo(String id, E o) {
            contenido = o;
            this.id = id;
            hijos = new ListaDoble<>();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Nodo<?> nodo = (Nodo<?>) o;
            return Objects.equals(id, nodo.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        public String getId() {
            return id;
        }

        public E getContenido() {
            return contenido;
        }

        public ListaDoble<Nodo<E>> getHijos() {
            return hijos;
        }

        public void setHijos(ListaDoble<Nodo<E>> hijos) {
            this.hijos = hijos;
        }
    }
}
