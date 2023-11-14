package dao.capaDao;

public abstract class FactoryDao {
    private static FactoryDao instance;

    public static FactoryDao getInstance() {
        if (instance == null) {
            instance = new FactoryDaoArchivo();
        }
        return instance;
    }

    public abstract EmpleadoDao newEmpleadoDao();
}
