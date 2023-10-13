package miscelaneo;

public class Persona implements Comparable<Persona>{
    private String nombre;
    private int edad;
    private String ci;

    public Persona(String n, int e) {
        nombre = n;
        edad = e;
    }
    public Persona(String ci, String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }

    @Override
    public int compareTo(Persona o) {
        return nombre.compareTo(o.getNombre());
    }

    public String getCi() {
        return ci;
    }
}
