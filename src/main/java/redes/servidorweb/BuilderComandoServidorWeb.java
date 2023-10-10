package redes.servidorweb;

import redes.servidorweb.comandos.ComandoLinea;
import redes.servidorweb.comandos.ComandoSesionComandos;
import redes.servidorweb.sesiones.Sesion;

public class BuilderComandoServidorWeb {

    private BuilderComandoServidorWeb() {
    }

    public static ComandoServidorWeb crear(String cmdGet) {
        if (cmdGet == null || cmdGet.isEmpty()) {
            return new ComandoVacio(cmdGet);
        }

        if (cmdGet.trim().equals("/tabla")) {
            return new ComandoTabla(cmdGet);
        }

        if (cmdGet.trim().equals("/imagen")) {
            return new ComandoImagen(cmdGet);
        }

        return new ComandoVacio(cmdGet);
    }

    public static ComandoServidorWeb crear(Sesion sesion, String cmdGet) {

        if (cmdGet.trim().startsWith("linea")) {
            return new ComandoLinea(cmdGet);
        }

        if (cmdGet.trim().startsWith("cmds")) {
            return new ComandoSesionComandos(sesion);
        }

        return new ComandoVacio(cmdGet);
    }
}
