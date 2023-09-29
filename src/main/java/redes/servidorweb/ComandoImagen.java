package redes.servidorweb;

import imagenes.objetos.Imagen;

public class ComandoImagen extends ComandoServidorWeb{
    public ComandoImagen(String cmd) {
        comando = cmd;
    }
    @Override
    public void ejecutar() {
        Imagen img = new Imagen(400,400);
        img.imagen4x4();
        resultadoImagen = img.getBytesPng();
    }

    @Override
    public boolean esResultadoTexto() {
        return false;
    }
}
