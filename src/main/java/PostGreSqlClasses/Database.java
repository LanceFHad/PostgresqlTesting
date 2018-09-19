package main.java.PostGreSqlClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Database
{
    private Connection conn;

    public Database()
    {
        try
        {
            Class.forName("org.postgresql.Driver");
            Properties properties = new Properties();
            properties.setProperty("user", "postgres");
            properties.setProperty("password", "");
//            properties.setProperty("ssl", "true");

            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", properties);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Error attempting to initialize JDBC driver");
            e.printStackTrace();
        }
        catch (SQLException SQLe)
        {
            System.out.println("Error in DriverManager.getConnection()");
            SQLe.printStackTrace();
        }
    }

    public void createTables() throws Exception
    {
        Statement stmt = null;

        try
        {
            stmt = conn.createStatement();
//            stmt.addBatch("create database if not exists Test");
            stmt.addBatch("create table if not exists Person (ID VARCHAR(255), Gender VARCHAR(255), Relations text, Facts text, AgeAtDeath int)");
        }
        catch (SQLException e)
        {

        }
        stmt.executeBatch();
    }
}
