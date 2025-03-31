package services;

import interfaces.repositories.ProdutoRepositoryInterface;
import interfaces.services.ProdutoServiceInterface;
import exceptions.ProdutoException;
import models.Produto;
import repositories.ProdutoRepository;

import java.util.List;

public class ProdutoService implements ProdutoServiceInterface {
    private ProdutoRepositoryInterface produtoRepository;
    
    public ProdutoService() {
        this.produtoRepository = new ProdutoRepository();
    }
    
    @Override
    public void addProduto(Produto produto) throws ProdutoException {
        if (produto == null) {
            throw new ProdutoException("Produto não pode ser nulo");
        }
        
        if (buscarPorId(produto.getId()) != null) {
            throw new ProdutoException("Já existe um produto com o ID " + produto.getId());
        }
        
        produtoRepository.addProduto(produto);
    }
    
    @Override
    public void removeProduto(int id) throws ProdutoException {
        Produto produto = buscarPorId(id);
        if (produto == null) {
            throw new ProdutoException("Produto com ID " + id + " não encontrado para remoção");
        }
        
        produtoRepository.removeProduto(id);
    }
    
    @Override
    public Produto buscarPorId(int id) throws ProdutoException {
        if (id <= 0) {
            throw new ProdutoException("ID deve ser maior que zero");
        }
        
        return produtoRepository.buscarPorId(id);
    }
    
    @Override
    public List<Produto> ListarTodosProdutos() {
        return produtoRepository.ListarTodosProdutos();
    }
    
    @Override
    public void removerUltimoProduto() throws ProdutoException {
        List<Produto> produtos = ListarTodosProdutos();
        if (produtos.isEmpty()) {
            throw new ProdutoException("Não há produtos para remover");
        }
        
        Produto ultimoProduto = produtos.get(produtos.size() - 1);
        produtoRepository.removeProduto(ultimoProduto.getId());
    }
    
    @Override
    public Produto obterUltimoProduto() throws ProdutoException {
        List<Produto> produtos = ListarTodosProdutos();
        if (produtos.isEmpty()) {
            throw new ProdutoException("Não há produtos cadastrados");
        }
        
        return produtos.get(produtos.size() - 1);
    }
    
    @Override
    public void atualizarProduto(int id, String nome, double preco) throws ProdutoException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new ProdutoException("Nome do produto não pode ser vazio");
        }
        
        if (preco < 0) {
            throw new ProdutoException("Preço não pode ser negativo");
        }
        
        Produto produto = buscarPorId(id);
        if (produto == null) {
            throw new ProdutoException("Produto não encontrado para atualização");
        }
        
        produtoRepository.removeProduto(id);
        produtoRepository.addProduto(new Produto(id, nome, preco));
    }
}
