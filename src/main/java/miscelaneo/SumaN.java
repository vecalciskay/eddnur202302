package miscelaneo;

/**
 * Suma de los primeros n numeros
 * s = n *(n+1) / 2
 */
public class SumaN {
    public static void main(String[] args) {
        int suma = 0;
        for (int i = 0; i < 100; i++) {  // 202 - 2 + 2n
            suma += i;  // 200 - 2n
        }
        // total = 402 ---  2 + 4n
        System.out.println(suma);
    }
}
