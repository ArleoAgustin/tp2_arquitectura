package dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    protected Connection conection;
    private String jdbc_driver = "com.mysql.cj.jdbc.Driver";
    private String db_url = "jdbc:mysql://LocalHost/dbMysql";

    public void conectar() throws Exception{

        try {
            Class.forName(jdbc_driver).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        try {
            conection = DriverManager.getConnection(db_url,"root", "admin");
            conection.setAutoCommit(false);

        } catch (
        SQLException e) {
            e.printStackTrace();
        }
    }











}
