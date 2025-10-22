package model.DAO;

import model.DAO.impl.CategoriaDAO;
import model.DAO.impl.ProdutoDAO;
import model.dataBase.DB;
import model.entities.Produto;

public class FactoryDAO {

    public static CategoriaDAO createCategoriaDao(){
        return new CategoriaDaoJDBC(DB.getConnection());
    }

    public static ProdutoDAO createProdutoDao(){
        return new ProdutoDaoJDBC();
    }

}
