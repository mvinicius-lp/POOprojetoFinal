import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.Serializable;

//item
class Item {
    private ArrayList<Produto> produtos;
    float total_vendas;

    public Item() {
        this.produtos = new ArrayList<>();
    }

    public void insert(Produto produto) throws IllegalArgumentException {
        boolean codigoExiste = false;
        
        for (Produto p : produtos) {
            if (p.getCod_prod().equals(produto.getCod_prod())) {
                codigoExiste = true;
                break;
            }
        }

        if (!codigoExiste) {
            this.produtos.add(produto);
            System.out.println("Produto adicionado com sucesso!");
        } else {
            throw new IllegalArgumentException("O código do produto já existe. Não é possível adicionar.");
        }
    }
    
    public void showProduto(String cod) throws IllegalArgumentException {
        boolean produtoEncontrado = false;

        for (Produto produto : produtos) {
            if (cod.equals(produto.getCod_prod())) {
                System.out.println("Produto: " + produto.getNome());
                System.out.println("Quantidade: " + produto.getQuantidade());
                produtoEncontrado = true;
                break;
            }
        }

        if (!produtoEncontrado) {
            throw new IllegalArgumentException("produto não encontrado");
        }
    }
    
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }
    
    public void realizarVenda(Scanner scanner, Mercantil mercantil) throws IllegalArgumentException {
        System.out.println("Você escolheu a opção 3: Realização de Vendas");

        System.out.println("Digite o código do cliente:");
        String codigoClienteVenda = scanner.next();
        Cliente clienteVenda = null;

        for (Cliente cliente : mercantil.getClientes()) {
            if (codigoClienteVenda.equals(cliente.getCodigo())) {
                clienteVenda = cliente;
                break;
            }
        }
        if (clienteVenda != null) {
            boolean continuarVenda = true;
            float total = 0;

            while (continuarVenda) {
                System.out.println("Digite o código do produto:");
                String codigoProdutoVenda = scanner.next();
                Produto produtoVenda = null;

                for (Produto produto : this.getProdutos()) {
                    if (codigoProdutoVenda.equals(produto.getCod_prod())) {
                        produtoVenda = produto;
                        break;
                    }
                }
                if (produtoVenda != null && produtoVenda.getQuantidade() > 0) {
                    System.out.println("Quantidade desejada:");
                    int quantidadeDesejada = scanner.nextInt();

                if (quantidadeDesejada <= produtoVenda.getQuantidade()) {
                    float subtotal = quantidadeDesejada * produtoVenda.getValor_venda();
                    if (clienteVenda instanceof ClienteVIP) {
                        // Aplicar desconto de 10% para clientes VIP
                        subtotal *= 0.9; // 10% de desconto
                    }
                    total += subtotal;
                    System.out.println("Total da venda: " + subtotal);
                    System.out.println("Venda realizada com sucesso!");
                    produtoVenda.setQuantidade(quantidadeDesejada);
                } else {
                        throw new IllegalArgumentException("Quantidade insuficiente em estoque!");
                    }
                } else {
                    throw new IllegalArgumentException("Produto não encontrado ou sem estoque!");
                }

                System.out.println("Deseja realizar outra venda? (s/n)");
                String resposta = scanner.next();

                if (!resposta.equalsIgnoreCase("s")) {
                    continuarVenda = false;
                    System.out.println("1 - Pagamento á Vista 2 - Crediário");
                    int opc = scanner.nextInt();
                    if(opc == 2){
                        clienteVenda.setSaldo(total);
                    }
                }
            }
         } else {
                throw new IllegalArgumentException("Cliente não encontrado!");
            }
        }

        public void exibirTodosProdutos() throws IllegalArgumentException {
            if (produtos.isEmpty()) {
                throw new IllegalArgumentException("Não há produtos cadastrados.");
            } else {
                System.out.println("Lista de Produtos:");
                for (Produto produto : produtos) {
                    System.out.println("Nome: " + produto.getNome());
                    System.out.println("Código: " + produto.getCod_prod());
                    System.out.println("Valor de compra: " + produto.getValor_compra());
                    System.out.println("Valor de venda: " + produto.getValor_venda());
                    System.out.println("Quantidade: " + produto.getQuantidade());
                    System.out.println("-----------");
                }
            }
        }
        public void deleteProduto(String cod) throws IllegalArgumentException {
        Produto produtoRemovido = null;

            for (Produto produto : produtos) {
                if (cod.equals(produto.getCod_prod())) {
                    produtoRemovido = produto;
                    break;
                }
            }

            if (produtoRemovido != null) {
                this.produtos.remove(produtoRemovido);
                System.out.println("Produto removido com sucesso!");
            } else {
                throw new IllegalArgumentException("Produto não encontrado para exclusão.");
            }
        }
    }