package application;


import model.DAO.CategoriaDaoJDBC;
import model.dataBase.DB;
import model.dataBase.dbException;
import model.entities.Categoria;
import model.entities.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try{

            PreparedStatement preparedStatement = DB.getConnection().prepareStatement("SELECT * FROM categorias");
            CategoriaDaoJDBC categoriaDaoJDBC = new CategoriaDaoJDBC(DB.getConnection());
            categoriaDaoJDBC.getAllCategorias();


        } catch (SQLException e) {
            throw new dbException(e.getMessage());
        }


 /*       int varMenu;
        do {
            System.out.println("BEM VINDO AO SISTEMA DE ESTOQUE MARKETPLACE!");
            System.out.println("-----MENU MARKETPLACE-----");
            System.out.println("1: CADASTRO DE CATEGORIAS PARA PRODUTOS");
            System.out.println("2: CADASTRO DE PRODUTOS");
            System.out.println("3: LISTAR CATEGORIAS");
            System.out.println("4: LISTAR PRODUTOS");
            System.out.println("5: SAIR");
            System.out.print("digite: ");
            varMenu = scanner.nextInt();


            switch (varMenu){

                case 1:



            }



        }while (varMenu > 0 && varMenu < 5);
*/

        scanner.close();

    }
}