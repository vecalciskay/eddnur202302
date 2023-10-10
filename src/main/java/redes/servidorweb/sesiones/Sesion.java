package redes.servidorweb.sesiones;

import listas.ListaDoble;
import redes.servidorweb.ComandoServidorWeb;

import java.util.Objects;

public class Sesion {
    private String id;
    private ListaDoble<ComandoServidorWeb> comandos;

    public Sesion(String id) {
        this.id = id;
        comandos = new ListaDoble<>();
    }

    public String toHtml() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("<h1>").append(id).append("</h1>");
        resultado.append("<table><thead><tr><th>Comando</th></tr></thead>");
        resultado.append("<tbody>");
        for (ComandoServidorWeb cmd:
             comandos) {
            resultado.append("<tr><td>").append(cmd.toString()).append("</td></tr>");
        }
        resultado.append("</tbody></table>");

        return resultado.toString();
    }

    public void insertarComando(ComandoServidorWeb cmd) {
        comandos.insertar(cmd);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sesion sesion = (Sesion) o;
        return id.equals(sesion.getId());
    }

    private String getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comandos);
    }
}
