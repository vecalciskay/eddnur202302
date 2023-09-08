package redes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProtocoloOperaciones {
    private final String OPERACION_REGEX =
            "^\\s*(SUMA|RESTA|MULT|DIV)\\s+([0-9]{1,5})\\s+([0-9]{1,5})\\s*$";
    private String comandoEntrada;
    public void entrada(String linea) {
        comandoEntrada = linea;

    }

    public String procesarSalida() {
        boolean valido = validarEntrada();
        if (!valido) {
            return "ERROR: No entiendo la operacion";
        }

        Pattern patronExpReg = Pattern.compile(OPERACION_REGEX);
        Matcher m = patronExpReg.matcher(comandoEntrada);

        m.find();
        String operacion = m.group(1);
        int arg1 = Integer.parseInt(m.group(2));
        int arg2 = Integer.parseInt(m.group(3));

        int resultado = 0;
        if (operacion.equals("SUMA"))
            resultado = arg1 + arg2;

        return String.valueOf(resultado);
    }

    /**
     * SUMA x y
     *  RESTA x y
     *  MULT x y
     *  DIV x y
     *     SUMA 4 32
     * @return
     */
    private boolean validarEntrada() {

        if (comandoEntrada.matches(OPERACION_REGEX)) {
            return true;
        }
        return false;
    }
}
