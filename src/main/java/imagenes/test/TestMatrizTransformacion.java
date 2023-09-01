package imagenes.test;

import imagenes.objetos.MatrizTransformacion;
import imagenes.objetos.Vector2;

public class TestMatrizTransformacion {
    public static void main(String[] args) {
        MatrizTransformacion m = new MatrizTransformacion();
        m.rotacion(-90);
        m.traslacion(3,0);

        Vector2 entrada = new Vector2(2,1);
        Vector2 salida = m.aplicarMatriz(entrada);
        System.out.println(salida);
    }
}
