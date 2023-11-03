package basedatos;

public class Empleado {
    private int ci_id;
    private String nombre;
    private String apellido;
    private double salario;

    public Empleado(int ci, String nom, String ape, double salario) {
        ci_id = ci;
        nombre=nom;
        apellido = ape;
        this.salario = salario;
    }

    public int getCi_id() {
        return ci_id;
    }

    public void setCi_id(int ci_id) {
        this.ci_id = ci_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "ci_id=" + ci_id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", salario=" + salario +
                '}';
    }
}
