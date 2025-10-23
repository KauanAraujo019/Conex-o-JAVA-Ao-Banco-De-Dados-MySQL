package model.DAO.impl;

import model.entities.Categoria;

import java.util.List;

public interface CategoriaDAO {

    void insertCategoria(Categoria categoria);
    void updateCategoria(Categoria categoria);
    void deleteCategoria(int id);
    List<Categoria> getAllCategorias();
    Categoria findByIdCategoria(int id);

}
