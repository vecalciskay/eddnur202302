package grafos;


import java.util.ArrayList;
import java.util.Stack;

// busqueda en profundidad
public class DFS {

    public static ArrayList<String> DFS(Grafo grafo,String idOrigen){
        // {1,2,3,4,5,6,7,8}
        ArrayList<String> recorrido = new ArrayList<>();
        Stack<String> pila = new Stack<>();
        pila.push(idOrigen); // 1
        while (!pila.isEmpty()){
            String id = pila.pop(); //
            if (!recorrido.contains(id)) {
                recorrido.add(id);
                Grafo.Nodo nodo = grafo.obtenerNodo(id);
                for (Object idKey: nodo.getSalientes().keySet()){
                    pila.add(idKey.toString()); // 9,5,2
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
        grafo.agregarRelacion("1","9");
        grafo.agregarRelacion("1","5");
        grafo.agregarRelacion("1","2");
        grafo.agregarRelacion("2","3");
        grafo.agregarRelacion("3","4");
        grafo.agregarRelacion("5","6");
        grafo.agregarRelacion("5","8");
        grafo.agregarRelacion("6","7");
        grafo.agregarRelacion("9","10");
        System.out.println(grafo.imprimir());
        ArrayList<String> listaOrdenada = DFS(grafo,"1");
        System.out.println(listaOrdenada);
    }
}
