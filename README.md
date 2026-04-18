Sistema de Controle de Biblioteca Escolar

## Tabelas Identificadas

Livro
- titulo
- autor
- quantidadeDisponivel

Aluno
- nome
- matricula

Emprestimo
- aluno
- livro
- ativo (status)

## Regras de Negócio

- Não permitir título de livro vazio
- Não permitir quantidade de exemplares negativa
- Não permitir empréstimo se não houver quantidade disponível
- Atualizar estoque automaticamente (decrementar no empréstimo / incrementar na devolução)
- Consultar quais livros estão emprestados no momento
- Consultar quais alunos possuem livros em aberto

## Tecnologias
- Java
- IntelliJ IDEA
- GitHub

## Estrutura
- Projeto 1: POO
- Projeto 2: MVC
