package models;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Eletronico extends Produto {
    private String marca;
    private String modelo;

    public Eletronico(int codigo, String nome, String descricao, int quantidade, double preco, String marca, String modelo) {
        super(codigo, nome, descricao, quantidade, preco);
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String exibirDetalhes() {
        return super.exibirDetalhes() + " | Marca: " + marca + " | Modelo: " + modelo;
    }

    @Override
    public void gravaEstoque(int codigo, String nome, String descricao, int quantidade, double preco) {
        gravaEstoque(codigo, nome, descricao, quantidade, preco, marca, modelo);
    }

    public void gravaEstoque(int codigo, String nome, String descricao, int quantidade, double preco, String marca, String modelo) {
    	 try {
             FileWriter ler = new FileWriter("estoque.txt", true);
             PrintWriter escrever = new PrintWriter(ler);
             escrever.println("Produtp | Código: " + codigo + " | Nome: " + nome + " | Descrição: " + descricao +
                     " | Quantidade: " + quantidade + " | Preço: " + preco + " | Modelo: " + modelo + " | Marca: " + marca  );
             escrever.close();
        } catch (IOException e) {
            System.out.println("Erro ao gravar no arquivo de estoque: " + e.getMessage());
        }
    }
}
