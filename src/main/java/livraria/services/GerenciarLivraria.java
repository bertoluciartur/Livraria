package livraria.services;

import livraria.model.Biblioteca;
import livraria.model.Cliente;

public class GerenciarLivraria {
    private Biblioteca biblioteca;
    private TelaLivraria telaLivraria;

    public GerenciarLivraria() {
        biblioteca = new Biblioteca();
        telaLivraria = new TelaLivraria();
        this.menu();
    }

    public void menu() {
        int option;
        do {
            option = telaLivraria.menuOption();
            switch (option) {
                case 1:
                    biblioteca.iterableLivrosDisponiveis();
                    break;

                case 2:
                    int idLivroEmprestimo = telaLivraria.escolherLivro();
                    if (biblioteca.podeEmprestar(idLivroEmprestimo)) {
                        Cliente cliente = obterCliente();
                        if (cliente != null) {
                            biblioteca.realizarEmprestimo(idLivroEmprestimo, cliente);
                        }
                    }
                    break;

                case 3:
                    biblioteca.searchBookOrAutor(telaLivraria.buscar());
                    break;

                case 4:
                    int idLivroDevolucao = telaLivraria.escolherLivro();
                    biblioteca.devolverLivro(idLivroDevolucao);
                    break;

                case 0:
                    System.out.println("\nSaindo...\n");
                    break;

                default:
                    System.out.println("\nOpcão inválida. Digite novamente\n");
            }
        } while (option != 0);
    }

    private Cliente obterCliente() {
        if (!biblioteca.existemClientes()) {
            String[] dados = telaLivraria.cadastrarNovoCliente();
            return biblioteca.cadastrarNovoCliente(dados[0], dados[1]);
        }

        int opcao = telaLivraria.escolherClienteOuNovo();

        if (opcao == 1) {
            biblioteca.iterableClientes();
            int idCliente = telaLivraria.escolherIdCliente();
            Cliente cliente = biblioteca.buscarClientePorId(idCliente);
            if (cliente == null) {
                System.out.println("\nCliente não encontrado.\n");
            }
            return cliente;
        } else if (opcao == 2) {
            String[] dados = telaLivraria.cadastrarNovoCliente();
            return biblioteca.cadastrarNovoCliente(dados[0], dados[1]);
        } else {
            System.out.println("\nOpção inválida.\n");
            return null;
        }
    }

}