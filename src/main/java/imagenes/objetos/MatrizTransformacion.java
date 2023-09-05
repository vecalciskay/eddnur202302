package imagenes.objetos;

import java.text.DecimalFormat;

public class MatrizTransformacion {
    private final double[][] matriz;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public MatrizTransformacion() {
        matriz = new double[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j)
                    matriz[i][j] = 1.0;
                else
                    matriz[i][j] = 0.0;
            }
        }
    }

    public MatrizTransformacion(double[][] m) {
        matriz = m;
    }

    public Vector2 aplicarMatriz(Vector2 xy) {
        double[] vector3 = new double[3];
        vector3[0] = xy.getX();
        vector3[1] = xy.getY();
        vector3[2] = 1.0;

        double[] resultado = new double[3];
        resultado[0] = matriz[0][0] * vector3[0] +
                matriz[0][1] * vector3[1] +
                matriz[0][2] * vector3[2];
        resultado[1] = matriz[1][0] * vector3[0] +
                matriz[1][1] * vector3[1] +
                matriz[1][2] * vector3[2];
        resultado[2] = matriz[2][0] * vector3[0] +
                matriz[2][1] * vector3[1] +
                matriz[2][2] * vector3[2];

        return new Vector2(resultado[0], resultado[1]);
    }

    public MatrizTransformacion rotacion(int grados) {
        double r=grados*Math.PI/180.0;
        MatrizTransformacion m1 = new MatrizTransformacion();
        m1.set(0,0, Math.cos(r));
        m1.set(0,1, Math.sin(r));
        m1.set(1,0, -Math.sin(r));
        m1.set(1, 1, Math.cos(r));

        return componer(m1);
    }

    public MatrizTransformacion traslacion(int x, int y) {
        MatrizTransformacion m1 = new MatrizTransformacion();
        m1.set(0,2, x);
        m1.set(1,2, y);

        return componer(m1);
    }

    public MatrizTransformacion escala(double x, double y) {
        MatrizTransformacion m1 = new MatrizTransformacion();
        m1.set(0,0, x);
        m1.set(1,1, y);

        return componer(m1);
    }

    public MatrizTransformacion componer(MatrizTransformacion m1) {
        double[][] m2 = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    m2[i][j] += m1.get(i,k) * this.get(k,j);
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = m2[i][j];
            }
        }
        return this;
    }

    public double get(int i, int j) {
        return matriz[i][j];
    }
    public void set(int i, int j, double valor) {
        matriz[i][j] = valor;
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            String separador = "";
            for (int j = 0; j < 3; j++) {
                String valor = df.format(matriz[i][j]);
                resultado.append(separador).append(valor);
                separador = "  ";
            }
            resultado.append("\n");
        }
        return resultado.toString();
    }

    public void copiar(MatrizTransformacion m) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = m.get(i,j);
            }
        }
    }
}
