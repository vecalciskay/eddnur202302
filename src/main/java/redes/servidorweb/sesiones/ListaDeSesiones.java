package redes.servidorweb.sesiones;

import listas.ListaDoble;

public class ListaDeSesiones {
    private ListaDoble<Sesion> sesiones;
    private static ListaDeSesiones instancia;

    public static ListaDeSesiones obtenerInstancia() {
        if (instancia == null)
            instancia = new ListaDeSesiones();
        return instancia;
    }

    private ListaDeSesiones() {
        sesiones = new ListaDoble<>();
    }

    public ListaDoble<Sesion> getSesiones() {
        return sesiones;
    }

    public Sesion crearSesion(String idsesion) {
        Sesion obj = new Sesion(idsesion);
        sesiones.insertar(obj);

        return obj;
    }
}
