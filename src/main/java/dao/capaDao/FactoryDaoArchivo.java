package dao.capaDao;

public class FactoryDaoArchivo extends FactoryDao{
    @Override
    public EmpleadoDao newEmpleadoDao() {
        return new EmpleadoDaoArchivo();
    }
}
