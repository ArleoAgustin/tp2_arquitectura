package connection;

public abstract class Connection {

    protected static  Connection instance;
    protected static java.sql.Connection conection;

    protected abstract void conectar() throws Exception;

}
