package system;

import java.util.Scanner;
import controller.opcoesMenu;
import java.util.InputMismatchException;

public class Main {

    private static Scanner scanner;



	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("###########################");
            System.out.println("Gerenciamento de Estoque");
            System.out.println("###########################");
            System.out.println("1. Criar novo produto");
            System.out.println("2. Ver produtos do estoque");
            System.out.println("3. Sair");
            System.out.println("###########################");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        criarNovoProduto();
                        break;
                    case 2:
                        opcoesMenu.lerProdutoDoEstoque();
                        break;
                    case 3:
                        System.out.println("Saindo do programa...");
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
            } catch (InputMismatchException e) {
                System.err.println("Digite um número válido.");
                scanner.nextLine(); 
                opcao = 0; 
            }
        } while (opcao != 3);

        scanner.close();
    }



    public static void criarNovoProduto() {
        int tipoProduto = 0;

        while (tipoProduto < 1 || tipoProduto > 3) {
            scanner = new Scanner(System.in);
            System.out.println("###########################");
            System.out.println("Criar Novo Produto");
            System.out.println("###########################");
            System.out.println("Selecione o tipo de produto:");
            System.out.println("1. Produto Genérico");
            System.out.println("2. Alimento");
            System.out.println("3. Eletrônico");
            System.out.println("###########################");
            try {
                tipoProduto = scanner.nextInt();
                scanner.nextLine();

                switch (tipoProduto) {
                    case 1:
                        opcoesMenu.criarNovoProdutoGenerico();
                        break;
                    case 2:
                    	opcoesMenu.criarNovoAlimento();
                        break;
                    case 3:
                    	opcoesMenu.criarNovoEletronico();
                        break;
                    default:
                        System.err.println("Opção inválida.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Digite um número válido.");
                scanner.nextLine(); 
            }
        }
    }
}
