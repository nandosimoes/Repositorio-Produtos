package models;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;


public class Alimento extends Produto {
    private LocalDate dataValidade;

    public Alimento(int codigo, String nome, String descricao, int quantidade, double preco, String dataValidade) {
        super(codigo, nome, descricao, quantidade, preco);
        this.dataValidade = LocalDate.parse(dataValidade);
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }
        	
    public static boolean setDataValidade(String dataValidadeString) {
        
        
        try {

        	if (dataValidadeString.length() != 10) {
                System.err.println("A data de validade deve ter exatamente 10 caracteres contando com as barras (yyyy-MM-dd) e a data deve ser pós 2024.");
                return false;
            }
        	
            String dia = dataValidadeString.substring(8, 10);
            String mes = dataValidadeString.substring(5, 7);
            String ano = dataValidadeString.substring(0, 4);
            
            int diaInt = Integer.parseInt(dia);
            int mesInt = Integer.parseInt(mes);
            int anoInt = Integer.parseInt(ano);
            
            if (diaInt < 1 || diaInt > 31 || mesInt < 1 || mesInt > 12 || anoInt < 2024 ) {
                System.err.println("Por favor, insira uma data de validade válida.");
                return false;
            }
           
            return true;
            
        } catch (NumberFormatException e) {
            System.err.println("A data de validade deve conter apenas números (yyyy-MM-dd).");
            return false;
        }
        
   
    }

    @Override
    public String exibirDetalhes() {
        return super.exibirDetalhes() + " | Data de Validade: " + dataValidade.toString();
    }

    @Override
    public void gravaEstoque(int codigo, String nome, String descricao, int quantidade, double preco) {
        try {
            FileWriter fw = new FileWriter("estoque.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("Alimento | Código: " + codigo + " | Nome: " + nome + " | Descrição: " + descricao +
                    " | Quantidade: " + quantidade + " | Preço: " + preco + " | Data de Validade: " + dataValidade.toString());
            pw.close();
        } catch (IOException e) {
            System.out.println("Erro ao gravar no arquivo de estoque: " + e.getMessage());
        }
    }

    public void gravaEstoque(int codigo, String nome, String descricao, int quantidade, double preco, String dataValidade) {
        setDataValidade(dataValidade);
        gravaEstoque(codigo, nome, descricao, quantidade, preco);
    }
}
