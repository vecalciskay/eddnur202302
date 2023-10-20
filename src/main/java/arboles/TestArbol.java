package arboles;

public class TestArbol {
    public static void main(String[] args) {
        Arbol<String> a = new Arbol<>();

        a.insertar("F","F", null);
        a.insertar("D", "D", "F");
        a.insertar("R", "R", "F");
        a.insertar("A", "A", "F");


        a.insertar("P", "P", "R");
        a.insertar("X", "X", "R");
        a.insertar("H", "H", "A");
        a.insertar("B", "B", "A");
        a.insertar("Z", "Z", "A");

        System.out.println(a);
    }
}
