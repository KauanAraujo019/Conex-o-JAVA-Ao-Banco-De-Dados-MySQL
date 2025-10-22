package model.dataBase;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

    static Connection conec = null;

    public static Connection getConnection(){
        try {

            if (conec == null) {
                Properties properties = loadProperties();

                String url = properties.getProperty("dburl");

                conec = DriverManager.getConnection(url, properties);

            }

        }
        catch (SQLException e){
            throw new dbException(e.getMessage());
        }


        return conec;

    }

    private static Properties loadProperties(){
        try(FileInputStream fileInputStream = new FileInputStream("db.properties")){
            Properties properties = new Properties();

            properties.load(fileInputStream);

            return properties;

        }
        catch (IOException e) {
            throw new dbException(e.getMessage());
        }

    }

    public static void closeConnection(){
        try {
            if (conec != null) {

                conec.close();

            }
        }
        catch (SQLException e){
            throw new dbException(e.getMessage());
        }

    }

    public static void closeStatement(Statement statement){
        try {
            if (statement != null) {

                statement.close();

            }
        }
        catch (SQLException e){
            throw new dbException(e.getMessage());
        }

    }




}
