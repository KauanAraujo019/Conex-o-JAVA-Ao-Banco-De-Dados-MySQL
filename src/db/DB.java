package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

    private static Connection connection = null;



    private static Connection getConnection(){

        if (connection == null){

            try {
                Properties properties = loadProperties();

                String urlDb = properties.getProperty("dburl");

                connection = DriverManager.getConnection(urlDb);

            }
            catch (SQLException e){
                throw new dbException(e.getMessage());
            }

        }

        return connection;

    }

    private static void closeConnection(){

        if(connection != null){

            try{
                connection.close();
            }
            catch (SQLException e){
                throw new dbException(e.getMessage());
            }

        }

    }


    private static Properties loadProperties(){

        try(FileInputStream file = new FileInputStream("db.properties")){
            Properties properties = new Properties();

            properties.load(file);

            return properties;

        } catch (IOException e) {
            throw new dbException(e.getMessage());
        }


    }




}
