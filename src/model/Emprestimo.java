package model;

public class Emprestimo {
    private Aluno aluno;
    private Livro livro;
    private boolean ativo;

    public Emprestimo(Aluno aluno, Livro livro) {
        this.aluno = aluno;
        this.livro = livro;
        this.ativo = true;
    }

    public Aluno getAluno() { return aluno; }
    public Livro getLivro() { return livro; }
    public boolean isAtivo() { return ativo; }

    public void finalizarDevolucao() {
        this.ativo = false;
        this.livro.devolver();
    }
}