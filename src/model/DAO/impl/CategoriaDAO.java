package model.DAO.impl;

import model.DAO.CategoriaDaoJDBC;
import model.entities.Categoria;

import java.util.List;

public interface CategoriaDAO {

    void insertCategoria(Categoria categoria);
    void updateCategoria(Categoria categoria);
    void deleteCategoria(Categoria categoria);
    List<Categoria> getAllCategorias();

}
