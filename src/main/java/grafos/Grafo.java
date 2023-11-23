package grafos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Grafo<E> {

    public HashMap<String, Nodo<E>> getNodos() {
        return nodos;
    }

    private HashMap<String,Nodo<E>> nodos;

    public Grafo() {
        nodos = new HashMap<>();
    }

    public void agregarNodo(String id, E contenido) {
        Nodo<E> nodo = new Nodo<>(id, contenido);
        nodos.put(id, nodo);
    }
    public Nodo obtenerNodo(String id) {
        return nodos.get(id);
    }
    public Integer getTotalNodos() {
        return nodos.size();
    }
    public void agregarArista(String idOrigen, String idDestino, int peso) {
        Nodo<E> origen = nodos.get(idOrigen);
        Nodo<E> destino = nodos.get(idDestino);
        Arista arista = new Arista(origen,destino,peso);
        Arista aristaViseversa = new Arista(destino,origen,peso);
        origen.salientes.add(arista);
        destino.salientes.add(aristaViseversa);
    }

    @Override
    public String toString() {
        String s = "";
        for (String id : nodos.keySet()) {
            Nodo<E> nodo = nodos.get(id);
            s += nodo.id + " -> ";
            for (Arista idSaliente : nodo.salientes) {
                s += idSaliente.hacia.id + "(" + idSaliente.peso + "), ";
            }
            s += "\n";
        }
        return s;
    }

    class Nodo<E> {
        public List<Arista<E>> getSalientes() {
            return salientes;
        }

        private List<Arista<E>> salientes;
        private E contenido;
        private String id;

        public Nodo(String id, E contenido) {
            salientes = new ArrayList<>();
            this.id = id;
            this.contenido = contenido;
        }

        public E getContenido() {
            return contenido;
        }

        public String getId() {
            return id;
        }

    }
    class Arista<E> {
        private Nodo<E> desde;
        private Nodo<E> hacia;
        private int peso;

        public Arista(Nodo<E> desde, Nodo<E> hacia, int peso) {
            this.desde = desde;
            this.hacia = hacia;
            this.peso = peso;
        }

        public Nodo<E> getDesde() {
            return desde;
        }

        public Nodo<E> getHacia() {
            return hacia;
        }

        public int getPeso() {
            return peso;
        }

        public void setDesde(Nodo<E> desde) {
            this.desde = desde;
        }

        public void setHacia(Nodo<E> hacia) {
            this.hacia = hacia;
        }

        public void setPeso(int peso) {
            this.peso = peso;
        }
    }
}
