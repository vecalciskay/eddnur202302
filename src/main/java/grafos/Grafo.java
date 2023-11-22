package grafos;

import java.util.HashMap;

public class Grafo<E> {
    private HashMap<String,Nodo<E>> nodos;

    public Grafo() {
        nodos = new HashMap<>();
    }

    public void agregarNodo(String id,E contenido) {
        Nodo<E> nodo = new Nodo<>(id,contenido);
        nodos.put(id,nodo);
    }

    public Nodo obtenerNodo(String id){
        return nodos.get(id);
    }
    // A B C D
    public String imprimir(){
        String s = "";
        for (String id: nodos.keySet()){
            Nodo<E> nodo = nodos.get(id);
            s += id + " ->";
            for (String idSaliente : nodo.salientes.keySet()){
                s += idSaliente + ", ";
            }
            s += "\n";
        }
        return s;
    }

    public void agregarRelacion(String idNodoOrigen, String idNodoDestino){
        Nodo<E> origen =  nodos.get(idNodoOrigen); // A
        Nodo<E> destino =  nodos.get(idNodoDestino); // B
        origen.salientes.put(idNodoDestino,destino); // A -> B
    }

    class Nodo<E> {
        private String id;
        private E contenido;

        public HashMap<String, Nodo<E>> getSalientes() {
            return salientes;
        }

        private HashMap<String,Nodo<E>> salientes;

        public Nodo(String id,E contenido){
            salientes = new HashMap<>();
            this.id = id;
            this.contenido = contenido;
        }
    }
    public static void main(String[] arg){
        Grafo grafo= new Grafo();
        grafo.agregarNodo("A","A");
        grafo.agregarNodo("B","B");
        grafo.agregarNodo("C","C");
        grafo.agregarNodo("D","D");
        grafo.agregarNodo("E","E");

        grafo.agregarRelacion("A","B");
        grafo.agregarRelacion("A","C");
        grafo.agregarRelacion("B","D");
        grafo.agregarRelacion("C","D");

        System.out.println(grafo.imprimir());
    }
}