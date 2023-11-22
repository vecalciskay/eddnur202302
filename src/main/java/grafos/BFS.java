package grafos;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// busqueda en profundidad
public class BFS {

    public static ArrayList<String> DFS(Grafo grafo,String idOrigen){
        // {1,2,3,4,5,6,7,8}
        ArrayList<String> recorrido = new ArrayList<>();
        Queue<String> cola = new LinkedList<>();
        cola.add(idOrigen); // 1
        while (!cola.isEmpty()){
            String id = cola.poll();
            if (!recorrido.contains(id)) {
                recorrido.add(id);
                Grafo.Nodo nodo = grafo.obtenerNodo(id);
                for (Object idKey: nodo.getSalientes().keySet()){
                    cola.add(idKey.toString());
                }
            }
        }
        return recorrido;
    }

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
        grafo.agregarRelacion("1","2");
        grafo.agregarRelacion("1","3");
        grafo.agregarRelacion("1","4");
        grafo.agregarRelacion("2","5");
        grafo.agregarRelacion("5","9");
        grafo.agregarRelacion("3","6");
        grafo.agregarRelacion("3","7");
        grafo.agregarRelacion("6","10");
        grafo.agregarRelacion("4","8");
        System.out.println(grafo.imprimir());
        ArrayList<String> listaOrdenada = DFS(grafo,"1");
        System.out.println(listaOrdenada);
    }
}
