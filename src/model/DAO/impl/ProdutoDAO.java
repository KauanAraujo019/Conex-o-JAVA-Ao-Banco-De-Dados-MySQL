package model.DAO.impl;

import model.entities.Produto;

import java.util.List;

public interface ProdutoDAO {

    void insertProduto(Produto produto);
    void updateProduto(Produto produto);
    void deleteProduto(int id);
    List<Produto> getAllProdutos();

}
