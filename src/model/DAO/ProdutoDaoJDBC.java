package model.DAO;

import model.DAO.impl.ProdutoDAO;
import model.dataBase.DB;
import model.dataBase.dbException;
import model.entities.Categoria;
import model.entities.Produto;

import java.net.FileNameMap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ProdutoDaoJDBC implements ProdutoDAO {

    private Connection connection;

    public ProdutoDaoJDBC(Connection connection){
        this.connection = connection;
    }
    @Override
    public void insertProduto(Produto produto) {

        PreparedStatement preparedStatement = null;

        try {

            preparedStatement = connection.prepareStatement("INSERT INTO produtos(nome_produto, preco_produto, UOM, quantidade, id_categoria "
                                                                +"VALUES (?, ?, ?, ?, ?)");


            preparedStatement.setString(1,produto.getNome());
            preparedStatement.setDouble(2, produto.getPreco());
            preparedStatement.setString(3, produto.getUom());
            preparedStatement.setInt(4, produto.getQuantidade());
            preparedStatement.setInt(5, produto.getCategoria().getId());


            preparedStatement.executeUpdate();

            System.out.println("Produto adicionado com sucesso!");


        } catch (SQLException e) {
            throw new dbException(e.getMessage());
        }
        finally {
            DB.closeStatement(preparedStatement);
        }

    }

    @Override
    public void updateProduto(Produto produto) {

        PreparedStatement preparedStatement = null;

        try{

            preparedStatement = connection.prepareStatement("UPDATE produtos SET nome_produto = ? " +
                                                                "preco_produto = ? " +
                                                                "UOM = ? " +
                                                                "quantidade = ? "+
                                                                "id_categoria = ?");


            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setDouble(2, produto.getPreco());
            preparedStatement.setString(3, produto.getUom());
            preparedStatement.setInt(4, produto.getQuantidade());
            preparedStatement.setInt(5, produto.getCategoria().getId());

            preparedStatement.executeUpdate();

            System.out.println("Produto atualizado com sucesso!");


        } catch (SQLException e) {
            throw new dbException(e.getMessage());
        }
        finally {
            DB.closeStatement(preparedStatement);
        }

    }

    @Override
    public void deleteProduto(int id) {

        PreparedStatement preparedStatement = null;

        try{

            preparedStatement = connection.prepareStatement("DELETE FROM produtos WHERE id = ?");


            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

            System.out.println("Produto deletado com sucesso!");


        } catch (SQLException e) {
            throw new dbException(e.getMessage());
        }
        finally {
            DB.closeStatement(preparedStatement);
        }


    }

    @Override
    public List<Produto> getAllProdutos() {
        PreparedStatement preparedStatement = null;

        try{

            preparedStatement = connection.prepareStatement("SELECT * FROM produtos");

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Produto> listaProdutos = new ArrayList<>();

            Map<Integer, Categoria> categoriasMap = new HashMap<>();

            while (resultSet.next()){

                int idP = resultSet.getInt("id");
                String nomeP = resultSet.getString("nome_produto");
                double precoP = resultSet.getDouble("preco_produto");
                String UOMP = resultSet.getString("UOM");
                int quantP = resultSet.getInt("quantidade");
                int idCatP = resultSet.getInt("id_categoria");

                if (categoriasMap.containsKey(idCatP)){
                    Produto produto = new Produto(idP, nomeP, precoP, UOMP, quantP, categoriasMap.get(idCatP));

                    listaProdutos.add(produto);
                }
                else{

                    CategoriaDaoJDBC cat = new CategoriaDaoJDBC(connection);

                    Categoria categoria = cat.findByIdCategoria(idCatP);

                    categoriasMap.put(idCatP, categoria);

                    Produto produto = new Produto(idP, nomeP, precoP, UOMP, quantP, categoriasMap.get(idCatP));

                    listaProdutos.add(produto);


                }


            }

            listaProdutos.forEach(p -> System.out.println("ID: "+p.getId()+" - NOME: "+p.getNome()+" - PREÇO: "+p.getPreco()+" - COD UOM: "+p.getUom()+" - QUANTIDADE: "+p.getQuantidade()+" - CATEGORIA -> id: "+p.getCategoria().getId()+" TIPO: "+p.getCategoria().getNome()));


        } catch (SQLException e) {
            throw new dbException(e.getMessage());
        }

        return null;

    }
}
