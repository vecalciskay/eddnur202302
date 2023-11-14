package dao.capaDao;

import basedatos.Empleado;
import listas.ListaDoble;

public interface EmpleadoDao {
    public ListaDoble<Empleado> get();
    public Empleado get(int id);
    public void update(Empleado o);
    public void insertar(Empleado o);
}
