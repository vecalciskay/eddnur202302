package redes.servidorweb;

public class ComandoVacio extends ComandoServidorWeb {
    public ComandoVacio(String cmd) {
        comando = cmd;
    }
    @Override
    public void ejecutar() {
        resultadoTexto = "500 Comando vacio";
    }

    @Override
    public boolean esResultadoTexto() {
        return true;
    }
}
