package listas;

import miscelaneo.Persona;

public class TestListaOrdenada {
    public static void main(String[] args) {
        ListaDobleOrdenada<String> a =  new ListaDobleOrdenada<>();


        a.insertar("Hugo");
        a.insertar("Paco");
        a.insertar("Luis");
        a.insertar("Daisy");
        a.insertar("McPato");
        a.insertar("Zoroastro");

        System.out.println(a);

        ListaDobleOrdenada<Persona> b =  new ListaDobleOrdenada<>();

        b.insertar(new Persona("Hugo", 50));
        b.insertar(new Persona("Paco", 30));
        b.insertar(new Persona("Luis", 64));
        b.insertar(new Persona("Daisy", 38));
        b.insertar(new Persona("McPato", 25));
        b.insertar(new Persona("Zoroastro", 35));

        System.out.println(b);
    }
}
