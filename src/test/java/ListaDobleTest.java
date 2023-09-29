import listas.ListaDoble;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListaDobleTest {

    @Test
    public void testReversa() {
        ListaDoble<String> s = new ListaDoble<>();
        s.insertar("Hugo");
        s.insertar("Paco");

        String resultado = s.toStringReversa();
        assertEquals("[Hugo]-->[Paco]-->", resultado);
    }
}
