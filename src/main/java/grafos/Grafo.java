package grafos;

import java.util.HashMap;

public class Grafo<E> {

    private HashMap<String,Nodo<E>> nodos;

    public Grafo() {
        nodos = new HashMap<>();
    }

    public void agregarNodo(String id, E contenido) {
        Nodo<E> nodo = new Nodo<>(id, contenido);
        nodos.put(id, nodo);
    }

    public void agregarArista(String idOrigen, String idDestino) {
        Nodo<E> origen = nodos.get(idOrigen);
        Nodo<E> destino = nodos.get(idDestino);
        origen.salientes.put(idDestino, destino);
        destino.entrantes.put(idOrigen, origen);
    }

    @Override
    public String toString() {
        String s = "";
        for (String id : nodos.keySet()) {
            Nodo<E> nodo = nodos.get(id);
            s += nodo.id + " -> ";
            for (String idSaliente : nodo.salientes.keySet()) {
                s += idSaliente + ", ";
            }
            s += "\n";
        }
        return s;
    }

    class Nodo<E> {
        private HashMap<String,Nodo<E>> entrantes;
        private HashMap<String,Nodo<E>> salientes;
        private E contenido;
        private String id;

        public Nodo(String id, E contenido) {
            entrantes = new HashMap<>();
            salientes = new HashMap<>();
            this.id = id;
            this.contenido = contenido;
        }

        public HashMap<String, Nodo<E>> getEntrantes() {
            return entrantes;
        }

        public HashMap<String, Nodo<E>> getSalientes() {
            return salientes;
        }

        public E getContenido() {
            return contenido;
        }

        public String getId() {
            return id;
        }
    }
}
