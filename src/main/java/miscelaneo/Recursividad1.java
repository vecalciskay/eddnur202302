package miscelaneo;

public class Recursividad1 {

    public void m() {
        m();
    }

    public int suma(int n) {
        if (n == 1)
            return 1;
        return n + suma(n-1);
    }

    public static void main(String[] args) {
        Recursividad1 obj = new Recursividad1();
        System.out.println(obj.suma(10));
    }
}
