package grafos;

import java.util.*;
import java.util.stream.Collectors;

public class DijkstraAlgoritmo {

    // creo el metodo de dijkstra que recibe un Grafo, un nodo Origen y un Nodo Destino
    public static void Dijkstra(Grafo g, Grafo.Nodo verticeInicial, Grafo.Nodo verticeDestino) {
        HashMap<String, Integer> nodoIdYacumulado = new HashMap<>();
        List<String> listaIdNodosARecorrer = new ArrayList<>();
        HashMap<String, String> predecesores = new HashMap<>();
        List<String> recorridos = new ArrayList<>();
        HashMap<String, List<String>> listaDeMejorRutas = new HashMap<>();


        nodoIdYacumulado.put(verticeInicial.getId(), 0);
        recorridos.add(verticeInicial.getId());
        listaIdNodosARecorrer.add(verticeInicial.getId());

        while (!listaIdNodosARecorrer.isEmpty()) {
            String nodoConMenorValor = obtenerNodoConMenorValor(listaIdNodosARecorrer, nodoIdYacumulado);
            listaIdNodosARecorrer.remove(nodoConMenorValor);

            Grafo.Nodo nodoActual = g.obtenerNodo(nodoConMenorValor);

            for (Object aristaObj : nodoActual.getSalientes()) {
                Grafo.Arista arista = (Grafo.Arista) aristaObj;
                Grafo.Nodo nodoDestino = arista.getHacia();
                int nuevoAcumulado = nodoIdYacumulado.get(nodoConMenorValor) + arista.getPeso();

                if (!nodoIdYacumulado.containsKey(nodoDestino.getId()) || nuevoAcumulado < nodoIdYacumulado.get(nodoDestino.getId())) {
                    nodoIdYacumulado.put(nodoDestino.getId(), nuevoAcumulado);
                    listaIdNodosARecorrer.add(nodoDestino.getId());
                    predecesores.put(nodoDestino.getId(), nodoConMenorValor);
                }
            }

            recorridos.add(nodoConMenorValor);
        }
        // Reconstruir el camino desde verticeDestino hasta verticeInicial
        List<String> recorrido = new ArrayList<>();
        String nodo = verticeDestino.getId();
        recorrido.add(nodo);
        while (predecesores.containsKey(nodo)) {
            nodo = predecesores.get(nodo);
            recorrido.add(nodo);
        }
        System.out.println(recorrido);
    }

    private static String obtenerNodoConMenorValor(List<String> nodos, Map<String, Integer> valores) {
        String nodoConMenorValor = nodos.get(0);
        for (String nodo : nodos) {
            if (valores.get(nodo) < valores.get(nodoConMenorValor)) {
                nodoConMenorValor = nodo;
            }
        }
        return nodoConMenorValor;
    }
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        grafo.agregarNodo("A","A");
        grafo.agregarNodo("B","B");
        grafo.agregarNodo("C","C");
        grafo.agregarNodo("D","D");
        grafo.agregarNodo("E","E");
        grafo.agregarNodo("F","F");
        grafo.agregarNodo("G","G");
        grafo.agregarNodo("H","H");
        grafo.agregarNodo("E","E");
        grafo.agregarArista("A","C",1);
        grafo.agregarArista("A","B",3);
        grafo.agregarArista("B","G",5);
        grafo.agregarArista("B","D",1);
        grafo.agregarArista("C","F",5);
        grafo.agregarArista("C","D",2);
        grafo.agregarArista("D","F",2);
        grafo.agregarArista("D","E",4);
        grafo.agregarArista("E","H",1);
        grafo.agregarArista("F","H",3);
        System.out.println(grafo);
        Grafo.Nodo a = grafo.obtenerNodo("A");
        Grafo.Nodo h = grafo.obtenerNodo("H");
        Dijkstra(grafo,a,h);
    }
}
