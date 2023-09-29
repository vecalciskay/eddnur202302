package redes.servidorweb;

public interface IComandoServidorWeb {
    public void ejecutar();
    public boolean esResultadoTexto();
    public String getResultadoTexto();
    public byte[] getResultadoImagen();
}
