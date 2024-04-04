package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Metodos {

    private static Scanner scanner;

    public static void writeToFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(content);
            System.out.println("Conteúdo escrito no arquivo com sucesso");
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    public static String readFromFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return content.toString();
    }

    public static int verificacao(String mensagem) {
        int entrada = 0;
        boolean valido = false;
        scanner = new Scanner(System.in);
        
        do {
            try {
                System.out.print(mensagem);
                entrada = scanner.nextInt();
                if (entrada < 0) {
                    System.err.println("Por favor, digite um número válido.");
                } else {
                    valido = true;
                }
            } catch (InputMismatchException e) {
                System.err.println("Por favor, digite um número válido.");
                scanner.nextLine();
            }
        } while (!valido);
        
        return entrada;
    }
}	