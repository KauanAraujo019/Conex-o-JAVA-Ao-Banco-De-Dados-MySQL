package application;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int varMenu;
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




        scanner.close();

    }
}