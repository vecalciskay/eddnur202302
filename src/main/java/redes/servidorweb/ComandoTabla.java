package redes.servidorweb;

public class ComandoTabla extends ComandoServidorWeb {
    public ComandoTabla(String cmd) {
        comando = cmd;
    }
    @Override
    public void ejecutar() {
        String filaJose = "<tr><td>Jose</td><td>Sanchez</td><td>20</td></tr>";
        String filaCarlos = "<tr><td>Carlos</td><td>Perez</td><td>30</td></tr>";
        resultadoTexto = "<html><body><h1>Tabla</h1>" +
                "<table><tr><th>Nombre</th><th>Apellido</th><th>Edad</th></tr>" +
                filaJose+ filaCarlos +
                filaJose + filaCarlos +
                filaJose + filaCarlos +
                filaJose + filaCarlos +
                "</table>" +
                "</body></html>";
    }

    @Override
    public boolean esResultadoTexto() {
        return true;
    }
}
