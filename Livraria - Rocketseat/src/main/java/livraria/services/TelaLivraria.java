package livraria.services;

import java.util.Scanner;
import livraria.model.Cliente;

public class TelaLivraria {
    private Scanner scanner = new Scanner(System.in);

    public int menuOption() {
        System.out.println("--MENU LIVRARIA--");
        System.out.println("1 - Ver livros disponíveis");
        System.out.println("2 - Realizar empréstimo");
        System.out.println("3 - Buscar por autor ou título");
        System.out.println("4 - Devolver livro");
        System.out.println("0 - Sair");
        return scanner.nextInt();
    }

    public String buscar() {
        System.out.println("Digite o que precisa pesquisar:");
        scanner.nextLine();
        return scanner.nextLine();
    }

    public int escolherLivro() {
        System.out.println("Digite o id do livro:");
        return scanner.nextInt();
    }

    public int escolherClienteOuNovo() {
        System.out.println("Cliente já cadastrado ou novo?");
        System.out.println("1 - Cliente já cadastrado");
        System.out.println("2 - Novo cliente");
        return scanner.nextInt();
    }

    public int escolherIdCliente() {
        System.out.println("Digite o id do cliente:");
        return scanner.nextInt();
    }

    public String[] cadastrarNovoCliente() {
        scanner.nextLine();
        System.out.println("Nome do cliente:");
        String nome = scanner.nextLine();
        System.out.println("Email do cliente:");
        String email = scanner.nextLine();
        return new String[]{nome, email};
    }

}