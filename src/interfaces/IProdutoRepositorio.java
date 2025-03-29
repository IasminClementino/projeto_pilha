package interfaces;

import java.util.ArrayList;


import Entidades.Produto;

public interface IProdutoRepositorio  {
    // Interface para o repositório de produtos, que define os métodos que devem ser implementados

    public void salvarProduto(Produto produto);

    public boolean removerProduto(int id);

    Produto buscarPorId(int id);

   ArrayList<Produto> ListarTodosProdutos();


    // Adiciona um produto à lista de produtos
    // produtos.add(produto);
}
