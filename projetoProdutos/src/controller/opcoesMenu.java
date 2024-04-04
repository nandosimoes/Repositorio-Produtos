package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import models.Alimento;
import models.Eletronico;
import models.Metodos;
import models.Produto;

public class opcoesMenu {
	 private static Scanner scanner;

	public static void criarNovoProdutoGenerico() {
	        scanner = new Scanner(System.in);
	        System.out.println("###########################");
	        System.out.println("Cadastrar Novo Produto Genérico");
	        System.out.println("###########################");
	        
	        int codigo = Metodos.verificacao("Digite o código do produto: ");
	        
	        System.out.print("Digite o nome do produto: ");
	        String nome = scanner.nextLine();
	        
	        System.out.print("Digite a descrição do produto: ");
	        String descricao = scanner.nextLine();
	        
	        int quantidade = Metodos.verificacao("Digite a quantidade em estoque: ");
	        
	        int preco = Metodos.verificacao("Digite o preço: ");
	        
	        Produto produto = new Produto(codigo, nome, descricao, quantidade, preco);
	        produto.gravaEstoque(codigo, nome, descricao, quantidade, preco);
	        System.out.println("Produto criado com sucesso e gravado no estoque.");
	    }
	 
	public static void criarNovoAlimento() {
        scanner = new Scanner(System.in);

        System.out.println("###########################");
        System.out.println("Cadastrar Novo alimento");
        System.out.println("###########################");

        int codigo = Metodos.verificacao("Digite o código do alimento: ");

        System.out.print("Digite o nome do produto:");
        String nome = scanner.nextLine();

        System.out.print("Digite a descrição do produto:");
        String descricao = scanner.nextLine();

        int quantidade = Metodos.verificacao("Digite a quantidade em estoque: ");
        double preco = Metodos.verificacao("Digite o preço do produto: ");
        
        String dataValidadeString = "";
        boolean dataValida = false;
        while (!dataValida) {
            System.out.print("Digite a data de validade do alimento (formato: yyyy/mm/dd): ");
            dataValidadeString = scanner.nextLine();
            dataValida = Alimento.setDataValidade(dataValidadeString);
            
        }

        Alimento alimento = new Alimento(codigo, nome, descricao, quantidade, preco, dataValidadeString);
        alimento.gravaEstoque(codigo, nome, descricao, quantidade, preco, dataValidadeString);
        System.out.println("Alimento criado com sucesso e gravado no estoque.");
    }

	  
	  public static void criarNovoEletronico() {
	        scanner = new Scanner(System.in);
	        System.out.println("###########################");
	        System.out.println("Cadastrar Novo eletronico");
	        System.out.println("###########################");
	        
	        int codigo = Metodos.verificacao("Digite o código do produto: ");
	        
	        System.out.print("Digite o nome do produto:");
	        String nome = scanner.nextLine();
	        
	        System.out.print("Digite a descrição do produto:");
	        String descricao = scanner.nextLine();
	        
	        int quantidade = Metodos.verificacao("Digite a quantidade em estoque: ");
	        int preco = Metodos.verificacao("Digite o preco: ");
	        
	        System.out.print("Digite a marca do eletrônico: ");
	        String marca = scanner.nextLine();
	        
	        System.out.print("Digite o modelo do eletrônico: ");
	        String modelo = scanner.nextLine();

	        Eletronico eletronico = new Eletronico(codigo, nome, descricao, quantidade, preco, marca, modelo);
	        eletronico.gravaEstoque(codigo, nome, descricao, quantidade, preco, marca, modelo);
	        System.out.println("Eletrônico criado com sucesso e gravado no estoque.");
	    }
	  
	  	public static void lerProdutoDoEstoque() {
		    System.out.println("### Ler Produtos do Estoque ###");
		    File file = new File("estoque.txt");

		    try (FileReader fr = new FileReader(file);
		         BufferedReader br = new BufferedReader(fr)) {

		        String line;
		        while ((line = br.readLine()) != null) {
		            System.out.println(line);
		        }

		    } catch (IOException e) {
		        System.out.println("Erro ao ler o arquivo do estoque: " + e.getMessage());
		    }
		}
	  	
	  	


}
