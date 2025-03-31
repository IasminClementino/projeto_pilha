package repositories;

import interfaces.repositories.ProdutoRepositoryInterface;
import models.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository implements ProdutoRepositoryInterface {
    private List<Produto> produtos;
    
    public ProdutoRepository() {
        this.produtos = new ArrayList<>();
    }
    
    @Override
    public void addProduto(Produto produto) {
        produtos.add(produto);
    }
    
    @Override
    public void removeProduto(int id) {
        produtos.removeIf(p -> p.getId() == id);
    }
    
    @Override
    public Produto buscarPorId(int id) {
        return produtos.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }
    
    @Override
    public List<Produto> ListarTodosProdutos() {
        return new ArrayList<>(produtos);
    }
}
