package arboles;

public class Operacion extends ObjetoAritmetico {
    private final TipoOperacion operacion;

    public Operacion(TipoOperacion o) {
        operacion = o;
    }

    @Override
    public String toString() {
        switch(operacion) {
            case Suma -> {return "+";}
            case Resta -> {return "-";}
            case Multiplicacion -> {return "*";}
            case Division -> {return "/";}
            default -> {return "NA";}
        }
    }

    public double ejecutar(double a, double b) {
        switch(operacion) {
            case Suma -> {return a + b;}
            case Resta -> {return a - b;}
            case Multiplicacion -> {return a * b;}
            case Division -> {return a / b;}
            default -> {return 0;}
        }
    }
}
