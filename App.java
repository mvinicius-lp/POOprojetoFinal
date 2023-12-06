import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

//app
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mercantil mercantil = new Mercantil();
        Item item = new Item();

        while (true) {
            try {
                System.out.println("");
                System.out.println("+----- SysBudega - Controle de Estoque e Vendas -----+");
                System.out.println("|                                                    |");
                System.out.println("|            1. Cadastro de Clientes                 |");
                System.out.println("|            2. Cadastro de Produtos                 |");
                System.out.println("|            3. Realização de Vendas                 |");
                System.out.println("|            4. Buscar Produto                       |");
                System.out.println("|            5. Buscar Cliente                       |");
                System.out.println("|            6. Exibir todos os produtos             |");
                System.out.println("|            7. Exibir todos os clientes             |");
                System.out.println("|            8. Deletar cliente                      |");
                System.out.println("|            9. Deletar produto                      |");
                System.out.println("|            0. Sair                                 |");
                System.out.println("|                                                    |");
                System.out.println("+----- SysBudega - Controle de Estoque e Vendas -----+");
                System.out.println("");

                int opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        try {
                            System.out.println("Digite 1 - Cliente Comum ou Digite 2 - Cliente VIP");
                            int op = scanner.nextInt();

                            switch(op){
                                case 1:
                                    System.out.println("Você escolheu a opção 1: Cadastro de Clientes");
                                    System.out.println("Nome do cliente");
                                    String nomeCliente1 = scanner.next();
                                    System.out.println("Código do cliente");
                                    String codigoCliente1 = scanner.next();
                                    Label label1 = Label.NORMAL;
                                    mercantil.insert(new Cliente(nomeCliente1, codigoCliente1, label1));
                                    break;

                                case 2:
                                    System.out.println("Você escolheu a opção 2: Cadastro de Clientes VIP");
                                    System.out.println("Nome do cliente");
                                    String nomeCliente2 = scanner.next();
                                    System.out.println("Código do cliente");
                                    String codigoCliente2 = scanner.next();
                                    Label label2 = Label.VIP;
                                    int desconto = 10; // 10% de desconto para clientes vips
                                    mercantil.insert(new ClienteVIP(nomeCliente2, codigoCliente2, label2, desconto));
                                    break;

                                default:
                                    System.out.println("Opção inválida");
                                    break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Insira um valor numérico.");
                            scanner.next(); 
                        } catch (IllegalArgumentException e) {
                            System.out.println("Erro: " + e.getMessage());
                        }
                        break;

                    case 2:
                        try {
                            System.out.println("Você escolheu a opção 2: Cadastro de Produtos");
                            System.out.println("Nome do produto");
                            String nomeProduto = scanner.next();
                            System.out.println("Código do produto");
                            String codigoProduto = scanner.next();
                            System.out.println("Valor de compra");
                            float valorCompra = scanner.nextFloat();
                            System.out.println("Valor de venda");
                            float valorVenda = scanner.nextFloat();
                            System.out.println("Quantidade de produtos");
                            int quantidadeProduto = scanner.nextInt();
                            item.insert(new Produto(nomeProduto, codigoProduto, valorCompra, valorVenda, quantidadeProduto));
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Insira um valor numérico.");
                            scanner.next(); 
                        } catch (IllegalArgumentException e) {
                            System.out.println("Erro: " + e.getMessage());
                        }
                        break;

                    case 3:
                        try {
                            item.realizarVenda(scanner, mercantil);
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Insira um valor numérico.");
                            scanner.next(); // Limpa o buffer do scanner
                        } catch (IllegalArgumentException e) {
                            System.out.println("Erro: " + e.getMessage());
                        }
                        break;
                    case 4:
                        try {
                            System.out.println("Você escolheu a opção 4: Buscar Produto");
                            System.out.println("Digite o código do produto");
                            String codigoProdutoConsulta = scanner.next();
                            item.showProduto(codigoProdutoConsulta);
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Insira um valor numérico.");
                            scanner.next(); // Limpa o buffer do scanner
                        }
                        break;

                    case 5:
                        try {
                            System.out.println("Você escolheu a opção 5: Buscar Cliente");
                            System.out.println("Digite o código do cliente");
                            String codigoClienteConsulta = scanner.next();
                            mercantil.showCliente(codigoClienteConsulta);
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Insira um valor numérico.");
                            scanner.next(); // Limpa o buffer do scanner
                        }
                        break;

                    case 6:
                        try {
                            System.out.println("Você escolheu a opção 6: Exibir todos os produtos");
                            item.exibirTodosProdutos();
                        } catch (Exception e) {
                            System.out.println("Erro: " + e.getMessage());
                        }
                        break;

                    case 7:
                        try {
                            System.out.println("Você escolheu a opção 7: Exibir todos os clientes");
                            mercantil.exibirTodosClientes();
                        } catch (Exception e) {
                            System.out.println("Erro: " + e.getMessage());
                        }
                        break;
                    case 8:
                        try {
                            System.out.println("Você escolheu a opção 9: Excluir Cliente");
                            System.out.println("Digite o código do cliente que deseja excluir:");
                            String codigoClienteExclusao = scanner.next();
                            mercantil.deleteCliente(codigoClienteExclusao);
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Insira um valor numérico.");
                            scanner.next(); // Limpa o buffer do scanner
                        }
                        break;
                    case 9:
                        try {
                            System.out.println("Você escolheu a opção 10: Excluir Produto");
                            System.out.println("Digite o código do produto que deseja excluir:");
                            String codigoProdutoExclusao = scanner.next();
                            item.deleteProduto(codigoProdutoExclusao);
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Insira um valor numérico.");
                            scanner.next(); // Limpa o buffer do scanner
                        }
                        break;
                    case 0:
                        System.out.println("Saindo do sistema. Até logo!");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
            }
        }
    }
}