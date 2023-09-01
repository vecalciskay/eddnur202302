package imagenes.objetos;

import java.util.Arrays;

public class Vector2 {
    private double[] vector;

    public Vector2(double x, double y) {
        vector = new double[2];
        vector[0] = x;
        vector[1] = y;
    }

    public double[] getVector() {
        return vector;
    }

    public double getX() {
        return vector[0];
    }

    public double getY() {
        return vector[1];
    }

    @Override
    public String toString() {
        return "Vector2{" +
                "vector=" + Arrays.toString(vector) +
                '}';
    }
}
