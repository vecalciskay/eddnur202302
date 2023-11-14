package dao;

import basedatos.Empleado;
import dao.capaDao.EmpleadoDao;
import dao.capaDao.EmpleadoDaoMysql;
import dao.capaDao.FactoryDao;
import listas.Lista;
import listas.ListaDoble;

public class TestDao {
    public static void main(String[] args) {

        // Patron DAO - Sin Abstract Factory
        /*
        EmpleadoDaoMysql dao = new EmpleadoDaoMysql();
        ListaDoble<Empleado> empleados = dao.get();
        System.out.println(empleados);

        Empleado o1 = dao.get(1);
        o1.setNombre("Alejandro");
        dao.update(o1);
*/
        // Patron DAO - Con Abstract Factory
        FactoryDao factory = FactoryDao.getInstance();
        EmpleadoDao dao2 = factory.newEmpleadoDao();
        ListaDoble<Empleado> empleados2 = dao2.get();
        System.out.println(empleados2);
    }
}
