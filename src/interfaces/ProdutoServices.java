package interfaces;

import models.Produto;
import java.util.List;

public interface ProdutoServices {
    // Interface para os serviços de produto, que define os métodos que devem ser implementados

    public void addProduto(Produto produto);

    public void removeProduto(int id);

    Produto buscarPorId(int id);

    List<Produto> ListarTodosProdutos();
}
