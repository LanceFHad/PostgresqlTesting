package main.java;

import main.java.PostGreSqlClasses.Database;

public class Main
{
    private static Database db;

    public static void main(String[] args)
    {
        try
        {
            db = new Database();
            db.createTables();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
