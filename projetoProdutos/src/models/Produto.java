package models;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Produto {
    private int codigo;
    private String nome;
    private String descricao;
    private int quantidade;
    private double preco;

    public Produto(int codigo, String nome, String descricao, int quantidade, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String exibirDetalhes() {
        return "Código: " + codigo + ", Nome: " + nome + ", Descrição: " + descricao +
                ", Quantidade: " + quantidade + ", Preço: " + preco;
    }

    public void gravaEstoque(int codigo, String nome, String descricao, int quantidade, double preco) {
    	 try {
             FileWriter ler = new FileWriter("estoque.txt", true);
             PrintWriter escrever = new PrintWriter(ler);
             escrever.println("Produto | Código: " + codigo + " | Nome: " + nome + " | Descrição: " + descricao +
                     " | Quantidade: " + quantidade + " | Preço: " + preco );
             escrever.close();
        } catch (IOException e) {
            System.err.println("Erro ao adicionar produto ao estoque: " + e.getMessage());
        }
    }
}
