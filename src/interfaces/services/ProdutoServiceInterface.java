package interfaces.services;

import java.util.List;
import exceptions.ProdutoException;
import models.Produto;

public interface ProdutoServiceInterface {
    public void addProduto(Produto produto) throws ProdutoException;

    public void removeProduto(int id) throws ProdutoException;

    Produto buscarPorId(int id) throws ProdutoException;

    List<Produto> ListarTodosProdutos();
    
    public void removerUltimoProduto() throws ProdutoException;
    
    public Produto obterUltimoProduto() throws ProdutoException;
    
    public void atualizarProduto(int id, String nome, double preco) throws ProdutoException;
}
