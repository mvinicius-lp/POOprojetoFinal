import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.Serializable;

//Cliente
class Cliente implements Serializable {
    private String nome;
    private String codigo;
    private float sal_devedor;
    private Label label; 

    Cliente(String nome, String codigo, Label label) {
        this.nome = nome;
        this.codigo = codigo;
        this.label = label;
        this.sal_devedor = 0;
    }

    public void setSaldo(float val) throws IllegalArgumentException {
        if (val < 0) {
            throw new IllegalArgumentException("O saldo devedor não pode ser um valor negativo.");
        }
        this.sal_devedor += val;
    }

    public String getNome() {
        return this.nome;
    }

    public Label getLabel() {
        return this.label;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public float getSalDevedor() {
        return this.sal_devedor;
    }

    public String toString() {
        return this.nome;
    }
}