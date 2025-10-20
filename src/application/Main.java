package application;


import db.DB;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        Connection connection = DB.getConnection();
        System.out.println("Banco De Dados Conectado!");

        DB.closeConnection();
        System.out.println("Banco De Dados Fechado!");



    }
}