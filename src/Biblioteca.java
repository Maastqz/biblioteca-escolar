import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Aluno> alunos = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
    }

    public void cadastrarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void realizarEmprestimo(Aluno aluno, Livro livro) {
        if (livro.getQuantidadeDisponivel() <= 0) {
            System.out.println("ERRO: O livro '" + livro.getTitulo() + "' não possui exemplares disponíveis.");
            return;
        }

        livro.emprestar();
        Emprestimo novoEmprestimo = new Emprestimo(aluno, livro);
        emprestimos.add(novoEmprestimo);
        System.out.println("Empréstimo realizado com sucesso: " + livro.getTitulo() + " para " + aluno.getNome());
    }

    public void registrarDevolucao(Aluno aluno, Livro livro) {
        for (Emprestimo e : emprestimos) {
            if (e.isAtivo() && e.getAluno().equals(aluno) && e.getLivro().equals(livro)) {
                e.finalizarDevolucao();
                System.out.println("Devolução registrada: " + livro.getTitulo());
                return;
            }
        }
        System.out.println("Nenhum empréstimo ativo encontrado para este aluno e livro.");
    }

    public void consultarEmprestimosAtivos() {
        System.out.println("\n--- RELATÓRIO DE EMPRÉSTIMOS ATIVOS ---");
        boolean encontrou = false;
        for (Emprestimo e : emprestimos) {
            if (e.isAtivo()) {
                System.out.println(e.getAluno().getNome() + " está com o livro: " + e.getLivro().getTitulo());
                encontrou = true;
            }
        }
        if (!encontrou) System.out.println("Não há empréstimos pendentes.");
    }
}