package listas;

import miscelaneo.Persona;

import java.util.HashMap;

public class TestHashtable {
    public static void main(String[] args) {
        HashMap<String, Persona> personas = new HashMap<>();

        Persona p = new Persona("231561SC", "Alberto", 54);
        personas.put(p.getCi(), p);
        p = new Persona("56151SC", "Hugo", 54);
        personas.put(p.getCi(), p);
        p = new Persona("998394SC", "Paco", 54);
        personas.put(p.getCi(), p);
        p = new Persona("387748SC", "Luis", 54);
        personas.put(p.getCi(), p);

        Persona x = personas.get("998394SC");
        System.out.println(x);
    }
}
