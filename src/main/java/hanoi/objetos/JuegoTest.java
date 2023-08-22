package hanoi.objetos;

public class JuegoTest {
    public static void main(String[] args) {
        Hanoi h = new Hanoi(3);
        System.out.println(h);
        h.resolver(0,2,1,3);
    }
}
