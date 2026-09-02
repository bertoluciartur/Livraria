package livraria.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros;
    private List<Autor> autores;
    private List<Cliente> clientes;
    private List<Emprestimo> emprestimos;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.autores = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
        this.carregarLivrosTeste();
    }

    private void carregarLivrosTeste() {
        Autor autor1 = new Autor(1, "Machado de Assis", LocalDate.of(1839, 6, 21));
        Autor autor2 = new Autor(2, "Clarice Lispector", LocalDate.of(1920, 12, 10));
        Autor autor3 = new Autor(3, "J.R.R. Tolkien", LocalDate.of(1892, 1, 3));

        this.autores.add(autor1);
        this.autores.add(autor2);
        this.autores.add(autor3);

        this.livros.add(new Livro(1, "Dom Casmurro", autor1));
        this.livros.add(new Livro(2, "Memórias Póstumas de Brás Cubas", autor1));
        this.livros.add(new Livro(3, "A Hora da Estrela", autor2));
        this.livros.add(new Livro(4, "O Senhor dos Anéis", autor3));
        this.livros.add(new Livro(5, "O Hobbit", autor3));
    }

    public void showItems(Livro livro) {
        System.out.println("\n");
        System.out.println("Id: " + livro.getId());
        System.out.println("Título: " + livro.getTitulo());
        System.out.println("Autor: " + livro.getAutor().getNome());
        System.out.println("Disponível: " + (livro.isDisponivel() ? "Sim" : "Não"));
    }

    public void iterableLivros() {
        for (Livro livro : this.livros) {
            this.showItems(livro);
        }
    }

    public void iterableLivrosDisponiveis() {
        for (Livro livro : this.livros) {
            if (livro.isDisponivel()) {
                this.showItems(livro);
            }
        }
    }

    public void searchBookOrAutor(String busca) {
        for (Livro livro : this.livros) {
            if (livro.getTitulo().toLowerCase().contains(busca.toLowerCase())) {
                this.showItems(livro);
            } else if (livro.getAutor().getNome().toLowerCase().contains(busca.toLowerCase())) {
                this.showItems(livro);
            }
        }
    }

    public Livro buscarLivroPorId(int id) {
        for (Livro livro : this.livros) {
            if (livro.getId() == id) {
                return livro;
            }
        }
        return null;
    }

    public Emprestimo buscarEmprestimoPorLivro(int idLivro) {
        for (Emprestimo emprestimo : this.emprestimos) {
            if (emprestimo.getLivro().getId() == idLivro && emprestimo.getDataDevolucao() == null) {
                return emprestimo;
            }
        }
        return null;
    }

    public Cliente buscarClientePorId(int id) {
        for (Cliente cliente : this.clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    public boolean existemClientes() {
        return !this.clientes.isEmpty();
    }

    public void iterableClientes() {
        for (Cliente cliente : this.clientes) {
            System.out.println("\nId: " + cliente.getId());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Email: " + cliente.getEmail());
        }
    }

    public Cliente cadastrarNovoCliente(String nome, String email) {
        Cliente cliente = new Cliente(this.clientes.size() + 1, nome, email);
        this.clientes.add(cliente);
        return cliente;
    }

    public boolean podeEmprestar(int idLivro) {
        Livro livro = this.buscarLivroPorId(idLivro);

        if (livro == null) {
            System.out.println("\nLivro não encontrado.\n");
            return false;
        }

        if (!livro.isDisponivel()) {
            System.out.println("\nEste livro já está emprestado.\n");
            return false;
        }

        return true;
    }

    public void realizarEmprestimo(int idLivro, Cliente cliente) {
        Livro livro = this.buscarLivroPorId(idLivro);

        if (livro == null || !livro.isDisponivel()) {
            return;
        }

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setId(this.emprestimos.size() + 1);
        emprestimo.setLivro(livro);
        emprestimo.setCliente(cliente);

        livro.setDisponivel(false);
        this.emprestimos.add(emprestimo);

        System.out.println("\nEmpréstimo realizado com sucesso!\n");
    }

    public void devolverLivro(int idLivro) {
        Livro livro = this.buscarLivroPorId(idLivro);

        if (livro == null) {
            System.out.println("\nLivro não encontrado.\n");
            return;
        }

        if (livro.isDisponivel()) {
            System.out.println("\nEste livro não está emprestado.\n");
            return;
        }

        Emprestimo emprestimo = this.buscarEmprestimoPorLivro(idLivro);
        if (emprestimo != null) {
            emprestimo.setDataDevolucao(java.time.LocalDate.now());
        }

        livro.setDisponivel(true);
        System.out.println("\nDevolução registrada com sucesso!\n");
    }

    public List<Livro> getLivros() {
        return livros;
    }
}