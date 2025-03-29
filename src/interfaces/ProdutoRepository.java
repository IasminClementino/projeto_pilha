package interfaces;

import java.util.List;
import models.Produto;

public interface ProdutoRepository  {
    // Interface para o repositório de produtos, que define os métodos que devem ser implementados

    public void addProduto(Produto produto);

    public void removeProduto(int id);

    Produto buscarPorId(int id);

    List<Produto> ListarTodosProdutos();
}
