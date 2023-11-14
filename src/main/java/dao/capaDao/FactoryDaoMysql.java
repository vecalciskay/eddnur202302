package dao.capaDao;

public class FactoryDaoMysql extends FactoryDao {

    @Override
    public EmpleadoDao newEmpleadoDao() {
        return new EmpleadoDaoMysql();
    }
}
