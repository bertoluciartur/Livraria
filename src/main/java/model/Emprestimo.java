package model;
import java.time.LocalDate;

public class Emprestimo {
    private int id;
    private Livro livro;
    private Cliente Cliente;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(int id, Livro  livro, String nomeCliente, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.id  = 0;
        this.livro = new Livro();
        this.Cliente = new Cliente();
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = LocalDate.now();
    }

    public Emprestimo(){
        this.id  = 0;
        this.livro = new Livro();
        this.Cliente = new Cliente();
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = LocalDate.now();
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Cliente getCliente() {
        return Cliente;
    }

    public void setCliente(Cliente Cliente) {
        this.Cliente = Cliente;
    }
}
