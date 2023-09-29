import listas.ListaGenerica;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListaGenericaTest {
    @Test
    public void testInsert() {
        ListaGenerica<String> a = new ListaGenerica<>();
        a.insertar("Hugo");
        a.insertar("Paco");
        String resultado = a.toString();
        assertEquals("[Paco]-->[Hugo]-->", resultado);
    }

    @Test
    public void testTamano() {
        // arrange
        ListaGenerica<String> a = new ListaGenerica<>();
        a.insertar("Hugo");
        a.insertar("Paco");
        a.insertar("Hugo");
        a.insertar("Paco");
        a.insertar("Luis");
        a.insertar("Paco");

        // act
        int t = a.tamano();

        // assert
        assertEquals(6, t);
    }
}
