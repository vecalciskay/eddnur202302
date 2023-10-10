package redes.servidorweb.comandos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import redes.servidorweb.ComandoServidorWeb;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComandoLinea extends ComandoServidorWeb {
    private static Logger logger = LogManager.getRootLogger();
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public ComandoLinea(String cmd) {
        String regex = "linea-([0-9]+)-([0-9]+)-([0-9]+)-([0-9]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cmd);

        if (!matcher.find()) {
            logger.warn("No es un comando LINEA, entonces no se procesa");
            return;
        }
        String sx1 = matcher.group(1);
        String sy1 = matcher.group(2);
        String sx2 = matcher.group(3);
        String sy2 = matcher.group(4);

        x1 = Integer.parseInt(sx1);
        y1 = Integer.parseInt(sy1);
        x2 = Integer.parseInt(sx2);
        y2 = Integer.parseInt(sy2);
    }

    @Override
    public void ejecutar() {
        resultadoTexto = "<html><body><h1>Linea</h1>" +
                "<p>De (" + x1 + ", " + y1 + ") a (" + x2 + ", " + y2 + ")" +
                "</body></html>";
    }

    @Override
    public boolean esResultadoTexto() {
        return true;
    }
}
