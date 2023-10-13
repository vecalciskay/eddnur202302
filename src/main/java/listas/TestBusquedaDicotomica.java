package listas;

public class TestBusquedaDicotomica {
    public static void main(String[] args) {
        ListaDobleOrdenada<String> lista = new ListaDobleOrdenada<>();
        String[] nombres = new String[]{
                "Juan", "María", "José", "Ana", "Pedro", "Luis", "Carlos", "David", "Daniel",
                "Elena", "Francisco", "Isabel", "Miguel", "Marta", "Pablo", "Roberto", "Susana", "Teresa",
                "Alberto", "Alejandra", "Alejandro", "Ángel", "Antonio", "Beatriz", "Blanca", "Carlos", "Carmen",
                "Daniela", "David", "Diego", "Eduardo", "Elena", "Enrique", "Fernando", "Francisco", "Gabriela",
                "Gonzalo", "Guillermo", "Héctor", "Irene", "Isabel", "Javier", "Juan", "Laura", "Luis",
                "Manuel", "María", "Marta", "Miguel", "Natalia", "Pablo", "Pedro", "Rafael", "Raquel",
                "Roberto", "Rosa", "Santiago", "Sebastián", "Susana", "Teresa", "Tomás", "Verónica", "Víctor",
                "Virginia"
        };

        for (int i = 0; i < nombres.length; i++) {

            lista.insertar(nombres[i]);
        }

        String encontrado = lista.buscar("Guillermo");

        System.out.println("Encontro el string");
    }
}
