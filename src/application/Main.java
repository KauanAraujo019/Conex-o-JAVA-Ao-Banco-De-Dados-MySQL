package application;


import model.DAO.FactoryDAO;
import model.DAO.impl.CategoriaDAO;
import model.DAO.impl.ProdutoDAO;
import model.dataBase.DB;
import model.entities.Categoria;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int varMenu;
        System.out.println("BEM VINDO AO SISTEMA DE ESTOQUE MARKETPLACE!");
        do {
            System.out.println("-----MENU MARKETPLACE-----");
            System.out.println("1: CADASTRO DE CATEGORIAS PARA PRODUTOS");
            System.out.println("2: CADASTRO DE PRODUTOS");
            System.out.println("3: LISTAR CATEGORIAS");
            System.out.println("4: LISTAR PRODUTOS");
            System.out.println("5: REMOVER CATEGORIA");
            System.out.println("6: REMOVER PRODUTO");
            System.out.println("7: SAIR");
            System.out.print("digite: ");
            varMenu = scanner.nextInt();
            scanner.nextLine();


            switch (varMenu){

                case 1:
                    System.out.print("Digite a categoria desejada: ");
                    String nameCat = scanner.nextLine();
                    Categoria categoria = new Categoria(null, nameCat);

                    CategoriaDAO cadastrarCat = FactoryDAO.createCategoriaDao();
                    cadastrarCat.insertCategoria(categoria);

                    System.out.println();
                    System.out.println("Categoria "+nameCat.toUpperCase()+" Cadastrada com sucesso!");
                    DB.closeConnection();
                    System.out.println("Digite qualquer tecla para continuar");
                    scanner.nextLine();

                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();

                    break;

                case 2:



            }



        }while (varMenu > 0 && varMenu < 5);




        scanner.close();

    }
}