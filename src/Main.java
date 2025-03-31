import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import facades.ProdutoFacade;
import models.Produto;
import utils.LimparTela;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static final String Separador = "-------------------------";

    public static void main(String[] args) {
        ProdutoFacade facade = new ProdutoFacade();
        int opcao = 0;
        
        do {
            exibirMenu();
            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); 
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine(); 
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }

            processarOpcao(opcao, facade);
            
            if (opcao != 7) {
                System.out.println("\nPressione ENTER para continuar...");
                scanner.nextLine();
            }
            
        } while (opcao != 7);
    }

    private static void exibirMenu() {
        LimparTela.limpar();
        System.out.println("GESTÃO DE PRODUTOS\n");

        System.out.println("1. Adicionar Produto");
        System.out.println("2. Remover Último Produto");
        System.out.println("3. Visualizar Último Produto");
        System.out.println("4. Visualizar Todos os Produtos");
        System.out.println("5. Buscar Produto por ID");
        System.out.println("6. Atualizar Produto");
        System.out.println("7. Sair");
        System.out.print("\nEscolha uma opção: ");
    }

    private static void processarOpcao(int opcao, ProdutoFacade facade) {
        LimparTela.limpar();
        switch (opcao) {
            case 1:
                adicionarProduto(facade);
                break;
            case 2:
                removerUltimoProduto(facade);
                break;
            case 3:
                visualizarUltimoProduto(facade);
                break;
            case 4:
                listarTodosProdutos(facade);
                break;
            case 5:
                buscarProdutoPorId(facade);
                break;
            case 6:
                atualizarProduto(facade);
                break;
            case 7:
                System.out.println("Saindo do sistema. Obrigado!");
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void adicionarProduto(ProdutoFacade facade) {
        System.out.println("ADICIONAR PRODUTO\n");
        
        int id = Inteiro("ID: ");
        if (id <= 0) return;
        
        double preco = valor("Preço: R$ ");
        if (preco < 0) return;
        
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        
        if (facade.adicionar(id, nome, preco)) {
            System.out.println("Produto adicionado com sucesso!");
        }
    }

    private static void removerUltimoProduto(ProdutoFacade facade) {
        System.out.println("REMOVER ÚLTIMO PRODUTO\n");
        
        if (facade.remover()) {
            System.out.println("Último produto removido com sucesso!");
        }
    }

    private static void visualizarUltimoProduto(ProdutoFacade facade) {
        System.out.println("ÚLTIMO PRODUTO CADASTRADO\n");
        
        Produto produto = facade.visualizar();
        if (produto != null) {
            System.out.println(produto);
        }
    }

    private static void listarTodosProdutos(ProdutoFacade facade) {
        System.out.println("LISTA DE PRODUTOS\n");
        
        List<Produto> produtos = facade.getProdutos();
        if (produtos.isEmpty()) {
            System.out.println("Não há produtos cadastrados");
            return;
        }
        
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println("Produto #" + (i+1));
            System.out.println(produtos.get(i));
            System.out.println(Separador);
        }
        
        System.out.println("Total de produtos: " + produtos.size());
    }

    private static void buscarProdutoPorId(ProdutoFacade facade) {
        System.out.println("BUSCAR PRODUTO\n");
        
        int id = Inteiro("Digite o ID do produto: ");
        if (id <= 0) return;
        
        Produto produto = facade.buscarPorId(id);
        if (produto != null) {
            System.out.println(Separador);
            System.out.println(produto);
        }
    }

    private static void atualizarProduto(ProdutoFacade facade) {
        System.out.println("ATUALIZAR PRODUTO\n");

        int id = Inteiro("ID do produto a atualizar: ");
        if (id <= 0) return;
        
        Produto produto = facade.buscarPorId(id);
        if (produto == null) return;
        
        System.out.println(Separador);
        System.out.println("Produto encontrado:");
        System.out.println(produto);
        System.out.println(Separador);
        System.out.println("Informe os novos dados:");
        
        double preco = valor("Novo preço: R$ ");
        if (preco < 0) return;
        
        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();
        
        if (facade.atualizarProduto(id, nome, preco)) {
            System.out.println("Produto atualizado com sucesso!");
        }
    }

    private static int Inteiro(String mensagem) {
        System.out.print(mensagem);
        try {
            int valor = scanner.nextInt();
            scanner.nextLine(); 
            
            if (valor <= 0) {
                System.out.println("O valor deve ser maior que zero");
                return -1;
            }
            
            return valor;
        } catch (InputMismatchException e) {
            System.out.println("Por favor, digite um número válido");
            scanner.nextLine();  
            return -1;
        }
    }

    private static double valor(String mensagem) {
        System.out.print(mensagem);
        try {
            double valor = scanner.nextDouble();
            scanner.nextLine();
            
            if (valor < 0) {
                System.out.println("O valor não pode ser negativo");
                return -1;
            }
            
            return valor;
        } catch (InputMismatchException e) {
            System.out.println("Por favor, digite um número válido");
            scanner.nextLine(); 
            return -1;
        }
    }
    

}