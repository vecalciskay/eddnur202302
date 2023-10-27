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

    public Numero ejecutar(Numero a, Numero b) {
        switch(operacion) {
            case Suma -> {return new Numero(a.getValor() + b.getValor());}
            case Resta -> {return new Numero(a.getValor() - b.getValor());}
            case Multiplicacion -> {return new Numero(a.getValor() * b.getValor());}
            case Division -> {return new Numero(a.getValor() / b.getValor());}
            default -> {return new Numero(0);}
        }
    }
}
