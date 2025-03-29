package Repositorios;

import interfaces.IProdutoRepositorio;
import java.util.ArrayList;


import Entidades.Produto;

public class ProdutoRepositorio implements IProdutoRepositorio {

    private ArrayList<Produto> produtos;

    public ProdutoRepositorio(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }
    
    public void salvarProduto(Produto produto){
        this.produtos.add(produto);
    }

   public Produto buscarPorId(int id){
    if (this.produtos != null) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
    } else {

        System.out.println("A lista de produtos está vazia.");
    }

    return null; 
    }

    public boolean removerProduto(int id){
        return produtos.removeIf(produto -> produto.getId() == id);
    }

    public ArrayList<Produto> ListarTodosProdutos(){
        return produtos;
    }

    

    
}

