import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.Serializable;

//mercantil
class Mercantil {
    private ArrayList<Cliente> clientes;

    public Mercantil() {
        this.clientes = new ArrayList<>();
    }

    public void insert(Cliente cliente) throws IllegalArgumentException {
        boolean codigoExiste = false;

        for (Cliente c : clientes) {
            if (c.getCodigo().equals(cliente.getCodigo())) {
                codigoExiste = true;
                break;
            }
        }

        if (!codigoExiste) {
            this.clientes.add(cliente);
            System.out.println("Cliente adicionado com sucesso!");
        } else {
            throw new IllegalArgumentException("O código do cliente já existe. Não é possível adicionar.");
        }
    }

    public void showCliente(String cod) {
        boolean clienteEncontrado = false;

        for (Cliente cliente : clientes) {
            if (cod.equals(cliente.getCodigo())) {
                System.out.println("Cliente: " + cliente.getNome());
                System.out.println("Tipo: " + cliente.getLabel());
                System.out.println("Saldo Devedor: " + cliente.getSalDevedor());
                clienteEncontrado = true;
                break;
            }
        }

        if (!clienteEncontrado) {
            System.out.println("fail: cliente sem cadastro");
        }
    }

    public void exibirTodosClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados.");
        } else {
            System.out.println("Lista de Clientes:");
            for (Cliente cliente : clientes) {
                System.out.println("Nome: " + cliente.getNome());
                System.out.println("Código: " + cliente.getCodigo());
                System.out.println("Tipo: " + cliente.getLabel());
                System.out.println("Saldo Devedor: " + cliente.getSalDevedor());
                System.out.println("-----------");
            }
        }
    }


    public void deleteCliente(String cod) {
        Cliente clienteRemovido = null;

        for (Cliente cliente : clientes) {
            if (cod.equals(cliente.getCodigo())) {
                clienteRemovido = cliente;
                break;
            }
        }

        if (clienteRemovido != null) {
            this.clientes.remove(clienteRemovido);
            System.out.println("Cliente removido com sucesso!");
        } else {
            System.out.println("Cliente não encontrado para exclusão.");
        }
    }
    
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
}