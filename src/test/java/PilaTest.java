import listas.Pila;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PilaTest {
    @Test
    public void testPushPop() {
        Pila<String> p = new Pila<>();
        p.push("Hugo");
        p.push("Paco");
        p.push("Luis");
        p.pop(); // saca Luis

        String resultado = p.pop();
        assertEquals("Paco", resultado);
    }
}
