package listas;

public class TestLista {
    public static void main(String[] args) {
        Lista a = new Lista();
        a.insertar("Hugo");
        a.insertar("Paco");
        a.insertar("Luis");
        a.insertar(5);

        System.out.println(a);
    }
}
