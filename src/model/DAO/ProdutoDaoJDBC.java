package model.DAO;

import model.DAO.impl.ProdutoDAO;
import model.entities.Produto;

import java.util.Collections;
import java.util.List;

public class ProdutoDaoJDBC implements ProdutoDAO {
    @Override
    public void insertProduto(Produto produto) {

    }

    @Override
    public void updateProduto(Produto produto) {

    }

    @Override
    public void deleteProduto(Produto produto) {

    }

    @Override
    public List<Produto> getAllProdutos(Integer id) {
        return Collections.emptyList();
    }
}
