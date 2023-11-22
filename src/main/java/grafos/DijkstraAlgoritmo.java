package grafos;

import java.util.*;

public class DijkstraAlgoritmo {

    // creo el metodo de dijkstra que recibe un Grafo, un nodo Origen y un Nodo Destino
    public static void Dijkstra(Grafo g, Grafo.Nodo verticeInicial, Grafo.Nodo verticeDestino) {
        HashMap<String, Integer> resultados = new HashMap<>(); // guardaré los nodos con su menor costo
        List<String> nodosPendientesRecorrer = new ArrayList<>(); // guardaré los nodos que me faltan por recorrer
        HashMap<String, String> predecesores = new HashMap<>();  // guardaré los nodos predecesores de cada nodo

        resultados.put(verticeInicial.getId(), 0);
        nodosPendientesRecorrer.add(verticeInicial.getId());

        while (!nodosPendientesRecorrer.isEmpty()) { // hasta que no tenga nodos pendientes por recorrer
            String nodoConMenorValor = obtenerNodoConMenorValor(nodosPendientesRecorrer, resultados); // obtengo el nodo con menor valor
            nodosPendientesRecorrer.remove(nodoConMenorValor); // lo remuevo de los nodos pendientes por recorrer

            Grafo.Nodo nodoActual = g.obtenerNodo(nodoConMenorValor);

            for (Object aristaObj : nodoActual.getSalientes()) {
                Grafo.Arista arista = (Grafo.Arista) aristaObj;
                Grafo.Nodo nodoDestino = arista.getHacia();
                int nuevoAcumulado = resultados.get(nodoConMenorValor) + arista.getPeso();

                if (!resultados.containsKey(nodoDestino.getId()) || nuevoAcumulado < resultados.get(nodoDestino.getId())) {
                    resultados.put(nodoDestino.getId(), nuevoAcumulado); // adicionamos si no existe o es menor
                    predecesores.put(nodoDestino.getId(), nodoConMenorValor); // adicionamos si no existe o es menor
                    nodosPendientesRecorrer.add(nodoDestino.getId());
                }
            }
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
// Santa Cruz - Ivirgazama 256
// Ivirgazama - Cochabamba 226
// Cochabamba - Oruro 215
// Oruro - Sucre 236
// Sucre - Aiquile 138
// Santa Cruz - Aiquile 344
// Santa Cruz - Vallegrande 250
// Vallegrande - Sucre 350