package arboles;

public class ArbolAritmetico {
    private Nodo raiz;

    public ArbolAritmetico(String expresion) {
        raiz = new Nodo(expresion);
    }

    @Override
    public String toString() {
        if (raiz == null)
            return "[VACIO]";
        return raiz.toString();
    }

    class Nodo {
        private Nodo izquierda;
        private Nodo derecha;
        private ObjetoAritmetico contenido;

        public Nodo(String expresionConEspacios) {
            leerExpresionRecursivamente(expresionConEspacios);
        }

        private void leerExpresionRecursivamente(String expresionConEspacios) {
            // (5+7)
            int numeroParentesis = 0;
            boolean expresionLeida = false;
            String expresion = expresionConEspacios.trim();

            try {
                double numero = Double.parseDouble(expresion);
                contenido = new Numero(numero);
                expresionLeida = true;
            } catch(NumberFormatException e) {
                // No es un numero, leemos de la manera normal
            }

            if (expresionLeida) {
                return;
            }

            for (int i = 0; i<expresion.length(); i++) {
                char c =  expresion.charAt(i);

                if (c == '(') {
                    numeroParentesis++;
                    continue;
                }
                if (c == ')') {
                    numeroParentesis--;
                    continue;
                }

                if (esOperacion(c) && numeroParentesis == 0) {
                    contenido = leerOperacion(c);
                    izquierda = new Nodo(expresion.substring(0, i));
                    derecha = new Nodo(expresion.substring(i+1));
                    expresionLeida = true;
                }
            }

            if (!expresionLeida) {
                // Si la expresion esta encerrada entre parentesis, quitar
                // los parentesis y volver a procesar
                if (numeroParentesis == 0) {
                    leerExpresionRecursivamente(
                            expresion.substring(1, expresion.length() - 1));
                }
            }
        }


        public Nodo(ObjetoAritmetico o) {
            contenido = o;
            izquierda = null;
            derecha = null;
        }

        private Operacion leerOperacion(char c) {
            switch(c) {
                case '+' -> {return new Operacion(TipoOperacion.Suma);}
                case '-' -> {return new Operacion(TipoOperacion.Resta);}
                case '*' -> {return new Operacion(TipoOperacion.Multiplicacion);}
                case '/' -> {return new Operacion(TipoOperacion.Division);}
                default -> {return new Operacion(TipoOperacion.NA);}
            }
        }

        private boolean esOperacion(char c) {
            return (c == '+' || c == '-' || c == '*' || c == '/');
        }

        public Nodo getIzquierda() {
            return izquierda;
        }

        public void setIzquierda(Nodo izquierda) {
            this.izquierda = izquierda;
        }

        public Nodo getDerecha() {
            return derecha;
        }

        public void setDerecha(Nodo derecha) {
            this.derecha = derecha;
        }

        public ObjetoAritmetico getContenido() {
            return contenido;
        }

        @Override
        public String toString() {
            if (contenido instanceof Numero) {
                return contenido.toString();
            }

            StringBuilder resultado = new StringBuilder();
            resultado.append("(");
            resultado.append(izquierda.toString());
            resultado.append(contenido.toString());
            resultado.append(derecha.toString());
            resultado.append(")");

            return resultado.toString();
        }
    }
}
