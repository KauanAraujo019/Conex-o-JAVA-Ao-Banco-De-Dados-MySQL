package model.DAO.impl;

import model.entities.Categoria;
import model.entities.Produto;

import java.util.List;

public interface ProdutoDAO {

    void insertProduto(Produto produto);
    void updateProduto(Produto produto);
    void deleteProduto(Produto produto);
    List<Produto> getAllProdutos(Integer id);

}
