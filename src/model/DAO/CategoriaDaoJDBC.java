package model.DAO;

import model.DAO.impl.CategoriaDAO;
import model.dataBase.DB;
import model.dataBase.dbException;
import model.entities.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoriaDaoJDBC implements CategoriaDAO {

    private Connection connection;

    public CategoriaDaoJDBC(Connection connection){
        this.connection = connection;
    }

    @Override
    public void insertCategoria(Categoria categoria) {

        PreparedStatement preparedStatement = null;

        try{

            preparedStatement = connection.prepareStatement("insert into categorias(categoria)\n"+
                    "value\n" +
                    "(?); ");

            preparedStatement.setString(1, categoria.getNome());

            preparedStatement.executeUpdate();

            System.out.println("Categoria inserida com sucesso!");


        } catch (SQLException e) {
            throw new dbException(e.getMessage());
        }
        finally {
            DB.closeStatement(preparedStatement);
        }


    }

    @Override
    public void updateCategoria(Categoria categoria) {

        PreparedStatement preparedStatement = null;

        try {

            preparedStatement = connection.prepareStatement("UPDATE categorias SET categoria = ? " +
                                                                "WHERE id = ?");


            preparedStatement.setString(1, categoria.getNome());
            preparedStatement.setInt(2, categoria.getId());

            preparedStatement.executeUpdate();

            System.out.println("Categoria atualizada com sucesso!");


        } catch (SQLException e) {
            throw new dbException(e.getMessage());
        }
        finally {
            DB.closeStatement(preparedStatement);
        }


    }

    @Override
    public void deleteCategoria(Categoria categoria) {
        PreparedStatement preparedStatement = null;

        try {

            preparedStatement = connection.prepareStatement("DELETE FROM categorias WHERE id = ? ");


            preparedStatement.setInt(1, categoria.getId());

            preparedStatement.executeUpdate();

            System.out.println("Categoria deletada com sucesso!");

        } catch (SQLException e) {
            throw new dbException(e.getMessage());
        }
        finally {
            DB.closeStatement(preparedStatement);
        }


    }

    @Override
    public List<Categoria> getAllCategorias() {

        PreparedStatement preparedStatement = null;

        try{

            preparedStatement = connection.prepareStatement("SELECT * FROM categorias ");

            ResultSet resultSet = preparedStatement.executeQuery();


            List<Categoria> listaCategoria = new ArrayList<>();

            while (resultSet.next()){

                int idC = resultSet.getInt("id");
                String nomeC = resultSet.getString("categoria");

                Categoria categoria = new Categoria(idC, nomeC);

                listaCategoria.add(categoria);


            }

            System.out.println("LISTA DE CATEGORIAS: ");
            listaCategoria.forEach(p -> System.out.println("ID: "+p.getId()+" Categoria: "+p.getNome()));


        } catch (SQLException e) {
            throw new dbException(e.getMessage());
        }

        return null;


    }
}
