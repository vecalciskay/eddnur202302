package imagenes.objetos;

public class MatrizTransformacion {
    private double[][] matriz;

    public MatrizTransformacion() {
        matriz = new double[3][3];

        matriz[0][0] = 1;
        matriz[0][1] = 0;
        matriz[0][2] = 0;

        matriz[1][0] = 0;
        matriz[1][1] = 1;
        matriz[1][2] = 0;

        matriz[2][0] = 0;
        matriz[2][1] = 0;
        matriz[2][2] = 1;
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

    public void rotacion(int grados) {
        double r=grados*Math.PI/180.0;
        matriz[0][0] = Math.cos(r);
        matriz[0][1] = Math.sin(r);
        matriz[1][0] = -Math.sin(r);
        matriz[1][1] = Math.cos(r);
    }

    public void traslacion(int x, int y) {
        matriz[0][2] = (double)x;
        matriz[1][2] = (double)y;
    }
}
