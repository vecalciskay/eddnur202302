package redes.servidorweb.comandos;

import redes.servidorweb.ComandoServidorWeb;
import redes.servidorweb.sesiones.Sesion;

public class ComandoSesionComandos extends ComandoServidorWeb {
    private Sesion sesion;

    public ComandoSesionComandos(Sesion s) {
        sesion = s;
    }
    @Override
    public void ejecutar() {
        resultadoTexto = "<html><body>" + sesion.toHtml() + "</body></html>";
    }

    @Override
    public boolean esResultadoTexto() {
        return true;
    }
}
