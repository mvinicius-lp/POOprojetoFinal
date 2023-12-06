import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.Serializable;

//produto
class Produto {
    private String nome;
    private String cod_prod;
    private float valor_compra;
    private float valor_venda;
    private int quantidade;

    Produto(String nome, String cod, float valor_compra, float valor_venda, int quantidade) {
        this.nome = nome;
        this.cod_prod = cod;
        this.valor_compra = valor_compra;
        this.valor_venda = valor_venda;
        this.quantidade = quantidade;
    }

    public void setQuantidade(int qtd){
        this.quantidade = this.quantidade - qtd;
    }

    public String getNome(){
        return this.nome;
    }
    
    public String getCod_prod(){
        return this.cod_prod;
    }
    
    public float getValor_compra(){
        return this.valor_compra;
    }
    
     public float getValor_venda(){
        return this.valor_venda;
    }
    
     public int getQuantidade(){
        return this.quantidade;
    }
}