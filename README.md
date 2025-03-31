# Sistema de Gerenciamento de Produtos - (Pilha)

Este projeto implementa um sistema de gerenciamento de produtos utilizando o padrão de estrutura de dados Pilha, desenvolvido em Java. O sistema permite adicionar, remover, atualizar e visualizar produtos através de uma interface de linha de comando.

## Funcionalidades

O sistema oferece as seguintes operações:

- **Adicionar Produto**: Cadastra um novo produto com ID, nome e preço
- **Remover Último Produto**: Remove o último produto adicionado (seguindo o conceito LIFO da pilha)
- **Visualizar Último Produto**: Exibe os detalhes do produto no topo da pilha
- **Listar Todos os Produtos**: Visualiza todos os produtos cadastrados
- **Buscar Produto por ID**: Pesquisa um produto específico
- **Atualizar Produto**: Modifica informações de um produto existente

## Estrutura do Projeto

O projeto segue uma arquitetura em camadas com os seguintes componentes:

- **Models**: Classes que representam as entidades do sistema (Produto)
- **Repositories**: Responsáveis pelo armazenamento dos dados
- **Services**: Implementam a lógica de negócio e validações
- **Facades**: Simplificam o uso dos serviços para os clientes
- **Interfaces**: Definem contratos para as implementações
- **Exceptions**: Classes para tratamento de erros específicos
- **Utils**: Utilitários para funcionalidades auxiliares

### Organização de Diretórios

```
projeto_pilha/
├── src/                   # Código-fonte
│   ├── models/            # Entidades do sistema
│   ├── repositories/      # Camada de acesso a dados
│   ├── services/          # Lógica de negócio
│   ├── facades/           # Simplificação do acesso às funcionalidades
│   ├── interfaces/        # Contratos e interfaces
│   │   ├── repositories/  
│   │   └── services/
│   ├── exceptions/        # Classes de exceção
│   ├── utils/             # Classes utilitárias
│   └── Main.java          # Ponto de entrada da aplicação
├── bin/                   # Arquivos compilados
└── .vscode/               # Configurações do VSCode
```

## Padrões de Design

O projeto utiliza os seguintes padrões de design:

- **Facade**: Simplifica o uso do sistema através da classe `ProdutoFacade`
- **Repository**: Separa a lógica de persistência de dados da lógica de negócios
- **Interface**: Define contratos claros entre as camadas do sistema
- **MVC**: Separa o modelo (Model), a lógica de negócio (Service) e a interface com o usuário (Main)

## Como Executar

Existem várias formas de executar este projeto:

### Usando os scripts batch (Windows)

1. Abra o Prompt de Comando
2. Navegue até a pasta raiz do projeto
3. Execute o script de compilação:
   ```
   build.bat
   ```
4. Execute o script para rodar o programa:
   ```
   run.bat
   ```

### Usando o VSCode

1. Abra o projeto no Visual Studio Code
2. Certifique-se de ter a extensão "Extension Pack for Java" instalada
3. Abra o arquivo `src/Main.java`
4. Clique no botão "Run" (▶️) no canto superior direito do editor
5. Alternativamente, pressione F5 para iniciar o programa em modo de depuração

### Usando a linha de comando

1. Abra o terminal
2. Navegue até a pasta raiz do projeto
3. Compile o projeto:
   ```
   javac -d bin -sourcepath src src\Main.java
   ```
4. Execute o programa:
   ```
   java -cp bin Main
   ```

## Requisitos do Sistema

- **Java Development Kit (JDK)**: versão 8 ou superior
  - Recomendado: JDK 17 LTS ou JDK 22 para recursos mais recentes
- **Ambiente de Desenvolvimento**:
  - Visual Studio Code com as extensões:
    - Extension Pack for Java
  - Alternativas: IntelliJ IDEA, Eclipse ou NetBeans

## Licença

Este projeto foi desenvolvido para fins educacionais e pode ser livremente utilizado para estudo e aprendizado.
