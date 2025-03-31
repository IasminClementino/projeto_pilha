package interfaces.repositories;

import java.util.List;
import models.Produto;

public interface ProdutoRepositoryInterface  {

    public void addProduto(Produto produto);

    public void removeProduto(int id);

    Produto buscarPorId(int id);

    List<Produto> ListarTodosProdutos();
}

