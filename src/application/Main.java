package application;

import db.DB;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        Connection connection = DB.getConnection();

        System.out.println("CONECTADO!");

        DB.closeConnection();

        System.out.println("DESCONECTADO!");


    }
}