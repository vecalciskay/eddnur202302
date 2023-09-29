package redes.servidorweb;

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
}
