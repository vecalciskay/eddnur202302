package redes.servidorweb;

public abstract class ComandoServidorWeb implements IComandoServidorWeb {
    protected String comando;
    protected String resultadoTexto;
    protected byte[] resultadoImagen;

    @Override
    public String getResultadoTexto() {
        return resultadoTexto;
    }

    @Override
    public byte[] getResultadoImagen() {
        return resultadoImagen;
    }

    public String getComando() {
        return comando;
    }
}
