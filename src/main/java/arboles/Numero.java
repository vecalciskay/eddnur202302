package arboles;

public class Numero extends ObjetoAritmetico{
    private double valor;

    public Numero(double v) {
        valor = v;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return String.valueOf( valor);
    }
}
