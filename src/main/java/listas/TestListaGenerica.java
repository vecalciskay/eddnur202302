package listas;

import java.util.Iterator;

public class TestListaGenerica {
    public static void main(String[] args) {
        ListaGenerica<String> a = new ListaGenerica<>();
        a.insertar("Hugo");
        a.insertar("Paco");
        a.insertar("Luis");
        a.eliminar(2);

        System.out.println(a);
        System.out.println(a.tamano());

        ListaGenerica<String> b = new ListaGenerica<>();
        b.adicionar("Hugo");
        b.adicionar("Paco");
        b.adicionar("Luis");

        System.out.println(b);
        System.out.println(b.tamano());

        Iterator<String> i = b.iterator();
        while(i.hasNext()) {
           String n = i.next();
            System.out.println(n);
        }

        // Correcto
        for(String s : b) {
            System.out.println(s);
        }

        // Estupidez
        for (int j = 0; j < b.tamano(); j++) {
            System.out.println(b.obtener(j));
        }
    }
}
