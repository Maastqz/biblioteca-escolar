package view;

import controller.Biblioteca;
import model.Aluno;
import model.Livro;

public class Main {
    public static void main(String[] args) {
        Biblioteca minhaBiblio = new Biblioteca();

        try {
            Livro l1 = new Livro("Java: Como Programar", "Deitel", 2);
            Livro l2 = new Livro("Clean Code", "Robert Martin", 1);
            minhaBiblio.cadastrarLivro(l1);
            minhaBiblio.cadastrarLivro(l2);

            Aluno a1 = new Aluno("Ana Silva", "2024001");
            Aluno a2 = new Aluno("Bruno Souza", "2024002");
            minhaBiblio.cadastrarAluno(a1);
            minhaBiblio.cadastrarAluno(a2);

            minhaBiblio.realizarEmprestimo(a1, l2); // Empresta Clean Code (tinha 1, agora 0)
            minhaBiblio.realizarEmprestimo(a2, l2); // Tenta emprestar Clean Code (deve dar erro)
            minhaBiblio.realizarEmprestimo(a2, l1); // Empresta Java

            minhaBiblio.consultarEmprestimosAtivos();

            minhaBiblio.registrarDevolucao(a1, l2);

            minhaBiblio.consultarEmprestimosAtivos();

        } catch (IllegalArgumentException e) {
            System.err.println("Erro no cadastro: " + e.getMessage());
        }
    }
}