import listas.Cola;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColaTest {
    @Test
    public void testPushPull() {
        Cola<String> p = new Cola<>();
        p.push("Hugo");
        p.push("Paco");
        p.push("Luis");
        p.pull(); // saca Luis

        String resultado = p.pull();
        assertEquals("Paco", resultado);
    }
}
