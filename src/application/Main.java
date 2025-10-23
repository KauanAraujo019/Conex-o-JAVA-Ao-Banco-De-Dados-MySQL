package application;


import model.DAO.FactoryDAO;
import model.DAO.impl.CategoriaDAO;
import model.DAO.impl.ProdutoDAO;
import model.dataBase.DB;
import model.dataBase.dbException;
import model.entities.Categoria;
import model.entities.Produto;


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
                    System.out.println("Digite qualquer tecla para continuar");
                    scanner.nextLine();

                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();

                    break;

                case 2:
                    System.out.print("Digite o nome do produto: ");
                    String nomeP = scanner.nextLine();
                    System.out.print("Digite o preço do produto: ");
                    double precoP = scanner.nextDouble();
                    System.out.print("Digite o COD UOM (UN, KG, G, PCT, CX, MT): ");
                    String codUOM = scanner.next();
                    System.out.print("Digite a quantidade: ");
                    int quantP = scanner.nextInt();
                    System.out.print("Digite o ID CATEGORIA do produto: ");
                    int idCatP = scanner.nextInt();

                    CategoriaDAO cat = FactoryDAO.createCategoriaDao();
                    Categoria categoria1 = cat.findByIdCategoria(idCatP);


                    Produto produto = new Produto(null, nomeP, precoP, codUOM, quantP, categoria1);

                    ProdutoDAO produtoDAO = FactoryDAO.createProdutoDao();

                    produtoDAO.insertProduto(produto);


                    System.out.println();
                    System.out.println("Produto "+produto.getNome().toUpperCase()+" Cadastrado com sucesso!");
                    System.out.println("Digite qualquer tecla para continuar");
                    scanner.nextLine();

                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();

                    break;
                case 3:
                    System.out.println("CATEGORIAS: ");
                    CategoriaDAO categoria2 = FactoryDAO.createCategoriaDao();
                    categoria2.getAllCategorias();


                    System.out.println("Digite qualquer tecla para continuar");
                    scanner.nextLine();

                    break;
                case 4:
                    System.out.println("CATEGORIAS: ");
                    ProdutoDAO produtoDAO2 = FactoryDAO.createProdutoDao();
                    produtoDAO2.getAllProdutos();


                    System.out.println("Digite qualquer tecla para continuar");
                    scanner.nextLine();
                    break;
                case 5:
                    System.out.print("Digite o ID da categoria: ");
                    int idC = scanner.nextInt();
                    System.out.println();

                    try {
                        CategoriaDAO categoriaDAO = FactoryDAO.createCategoriaDao();
                        categoriaDAO.deleteCategoria(idC);

                        System.out.println();
                        System.out.println("Categoria deletada com sucesso!");

                        System.out.println("Digite qualquer tecla para continuar");

                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();

                        scanner.nextLine();

                    } catch (Exception e) {
                        throw new dbException(e.getMessage());
                    }

                    break;
                case 6:
                    System.out.print("Digite o ID da categoria: ");
                    int idP = scanner.nextInt();
                    System.out.println();

                    try {
                        ProdutoDAO produtoDAO1 = FactoryDAO.createProdutoDao();
                        produtoDAO1.deleteProduto(idP);

                        System.out.println();
                        System.out.println("Produto deletado com sucesso!");

                        System.out.println("Digite qualquer tecla para continuar");

                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();

                        scanner.nextLine();

                    } catch (Exception e) {
                        throw new dbException(e.getMessage());
                    }

                    break;




            }



        }while (varMenu > 0 && varMenu < 7);




        scanner.close();

    }
}