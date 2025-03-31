package facades;
//projeto_pilha
import models.Produto;
import services.ProdutoService;
import exceptions.ProdutoException;

import java.util.List;

public class ProdutoFacade {
    private ProdutoService produtoService;

    public ProdutoFacade() {
        this.produtoService = new ProdutoService();
    }

    public boolean adicionar(int id, String nome, double preco) {
        try {
            Produto produto = new Produto(id, nome, preco);
            produtoService.addProduto(produto);
            return true;
        } catch (ProdutoException e) {
            System.out.println("→ " + e.getMessage());
            return false;
        }
    }

    public boolean remover() {
        try {
            produtoService.removerUltimoProduto();
            return true;
        } catch (ProdutoException e) {
            System.out.println("→ " + e.getMessage());
            return false;
        }
    }

    public Produto visualizar() {
        try {
            return produtoService.obterUltimoProduto();
        } catch (ProdutoException e) {
            System.out.println("→ " + e.getMessage());
            return null;
        }
    }
    
    public void listarTodos() {
        List<Produto> produtos = produtoService.ListarTodosProdutos();
        if (produtos.isEmpty()) {
            System.out.println("→ Não há produtos cadastrados");
        }
    }
    
    public Produto buscarPorId(int id) {
        try {
            Produto produto = produtoService.buscarPorId(id);
            if (produto == null) {
                System.out.println("→ Produto não encontrado");
            }
            return produto;
        } catch (ProdutoException e) {
            System.out.println("→ " + e.getMessage());
            return null;
        }
    }
    
    public boolean atualizarProduto(int id, String nome, double preco) {
        try {
            produtoService.atualizarProduto(id, nome, preco);
            return true;
        } catch (ProdutoException e) {
            System.out.println("→ " + e.getMessage());
            return false;
        }
    }
    
    public boolean removeProduto(int id) {
        try {
            produtoService.removeProduto(id);
            return true;
        } catch (ProdutoException e) {
            System.out.println("→ " + e.getMessage());
            return false;
        }
    }
    
    public List<Produto> getProdutos() {
        return produtoService.ListarTodosProdutos();
    }
}
