package arboles;

import listas.ListaDoble;

import java.awt.*;
import java.util.HashMap;
import java.util.Objects;

public class Arbol<E> {

    private Nodo<E> raiz;
    private HashMap<String,Nodo<E>> nodos;

    public Arbol() {
        this.raiz = null;
        nodos = new HashMap<>();
    }

    public void insertar(String id, E o, String idpadre) {
        // Buscar si no existe ya ese nodo
        Nodo<E> duplicado = nodos.get(id);
        if (duplicado != null)
            throw new IllegalArgumentException("Ese nodo ya existe");

        // Si idpadre es nulo, el nodo nuevo es la raiz
        if (idpadre == null) {
            raiz = new Nodo<>(id, o);
            nodos.put(id, raiz);
            return;
        }

        // Buscar el nodo..... IDEA: Tabla de hash
        Nodo<E> padre = nodos.get(idpadre);
        if (padre == null)
            throw new IllegalArgumentException("El idpadre no corresponde a ningun nodo");

        Nodo<E> hijo = new Nodo(id, o);
        padre.insertarHijo(hijo);
        nodos.put(id, hijo);
    }

    @Override
    public String toString() {
        return raiz.toString();
    }

    public void dibujar(Graphics g) {
        raiz.dibujar(g,50,50);
    }

    class Nodo<E> {
        private String id;
        private E contenido;
        private ListaDoble<Nodo<E>> hijos;

        private static final int ESP_HORIZONTAL = 20;
        private static final int ESP_VERTICAL = 50;
        private static final int TAMANO_NODO = 50;

        public Nodo(String id, E o) {
            contenido = o;
            this.id = id;
            hijos = new ListaDoble<>();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Nodo<?> nodo = (Nodo<?>) o;
            return Objects.equals(id, nodo.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        public String getId() {
            return id;
        }

        public E getContenido() {
            return contenido;
        }

        public ListaDoble<Nodo<E>> getHijos() {
            return hijos;
        }

        public void setHijos(ListaDoble<Nodo<E>> hijos) {
            this.hijos = hijos;
        }

        public void insertarHijo(Nodo<E> hijo) {
            hijos.insertar(hijo);
        }

        @Override
        public String toString() {
            StringBuilder resultado = new StringBuilder();

            resultado.append(contenido.toString());

            if (hijos.tamano() == 0)
                return resultado.toString();

            resultado.append(" (");

            String separador = "";
            for (Nodo<E> hijo:
                 hijos) {
                resultado.append(separador);
                resultado.append(hijo.toString());
                separador = " ";
            }

            resultado.append(")");

            return resultado.toString();
        }

        public void dibujar(Graphics g, int x, int y) {
            if (hijos.tamano() == 0) {
                dibujarSolamenteNodo(g, x, y);
            }

            int ancho = getAnchoTotal();

            int cx = x + ancho/2;
            int cy = y + TAMANO_NODO / 2;

            int yHijo = y + TAMANO_NODO + ESP_VERTICAL;
            int xHijo = x;
            for (Nodo<E> hijo :
                    hijos) {

                int anchoHijo = hijo.getAnchoTotal();
                g.drawLine(cx, cy, xHijo + anchoHijo / 2, yHijo + TAMANO_NODO / 2);
                hijo.dibujar(g, xHijo, yHijo);

                xHijo += (ESP_HORIZONTAL + anchoHijo);
            }

            dibujarSolamenteNodo(g, x + ancho/2 - TAMANO_NODO/2 , y);
        }

        public int getAnchoTotal() {
            if (hijos.tamano() == 0)
                return TAMANO_NODO;

            int resultado = 0;
            int separacion = 0;
            for (Nodo<E> hijo :
                    hijos) {
                int anchoHijo = hijo.getAnchoTotal();
                resultado += (separacion + anchoHijo);
                separacion = ESP_HORIZONTAL;
            }

            return resultado;
        }

        private void dibujarSolamenteNodo(Graphics g, int x, int y) {
            g.setColor(Color.white);
            g.fillArc(x, y, TAMANO_NODO, TAMANO_NODO, 0, 360 );

            g.setColor(Color.black);
            g.drawArc(x, y, TAMANO_NODO, TAMANO_NODO, 0, 360 );
            g.drawString(contenido.toString(),
                    x + TAMANO_NODO / 2 - 3, y + TAMANO_NODO / 2 + 5);
        }
    }
}
