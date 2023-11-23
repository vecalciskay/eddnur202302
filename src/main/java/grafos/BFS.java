package grafos;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    // usando el grafo de la clase Grafo realizo el recorrido BFS utilizando la clase Queue de Java

    public static ArrayList<String> recorrido(Grafo grafo, String idOrigen) {
        ArrayList<String> recorrido = new ArrayList<>();
        Queue<String> cola = new LinkedList<>();
        cola.add(idOrigen);
        while (!cola.isEmpty()) {
            String id = cola.remove();
            if (!recorrido.contains(id)) {
                recorrido.add(id);
                Grafo.Nodo nodo = grafo.obtenerNodo(id);
                for (Object arista : nodo.getSalientes()) {
                    Grafo.Arista arista1 = (Grafo.Arista) arista;
                    System.out.println("de nodo " + id + " sale " + arista1.getHacia().getId());
                    cola.add(arista1.getHacia().getId());
                }
            }
        }
        return recorrido;
    }

    // probando el recorrido BFS
    public static void main(String[] args) {
        Grafo<String> grafo = new Grafo<>();
        grafo.agregarNodo("1","1");
        grafo.agregarNodo("2","2");
        grafo.agregarNodo("3","3");
        grafo.agregarNodo("4","4");
        grafo.agregarNodo("5","5");
        grafo.agregarNodo("6","6");
        grafo.agregarNodo("7","7");
        grafo.agregarNodo("8","8");
        grafo.agregarNodo("9","9");
        grafo.agregarNodo("10","10");
        grafo.agregarArista("1","2",2);
        grafo.agregarArista("1","3",1);
        grafo.agregarArista("1","4",1);
        grafo.agregarArista("2","5",1);
        grafo.agregarArista("5","9",1);
        grafo.agregarArista("3","6",1);
        grafo.agregarArista("3","7",1);
        grafo.agregarArista("6","10",1);
        grafo.agregarArista("4","8",1);
        ArrayList<String> recorrido = recorrido(grafo, "1");
        System.out.println(recorrido);
    }
}
