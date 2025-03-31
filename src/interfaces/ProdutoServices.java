package interfaces;

import java.util.List;

import Models.Produto;

public interface ProdutoServices {
    // Interface para os serviços de produto, que define os métodos que devem ser implementados

    public void addProduto(Produto produto);

    public void removeProduto(int id);

    Produto buscarPorId(int id);

    List<Produto> ListarTodosProdutos();
}
