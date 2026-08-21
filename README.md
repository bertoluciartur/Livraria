# Sistema de Livraria

Sistema de console em Java para gerenciamento de empréstimos de livros de uma biblioteca. Projeto desenvolvido para a disciplina de Engenharia de Software, seguindo o modelo proposto pela Rocketseat.

## Funcionalidades

- Listagem de livros disponíveis
- Realização de empréstimo (com validação de disponibilidade)
- Busca por título ou autor
- Devolução de livro
- Cadastro de cliente (novo ou já existente)

## Estrutura do projeto

```
src/main/java/livraria/
├── model/
│   ├── Autor.java
│   ├── Biblioteca.java
│   ├── Cliente.java
│   ├── Emprestimo.java
│   └── Livro.java
└── services/
    ├── GerenciarLivraria.java
    └── TelaLivraria.java
```

- **model** — entidades do domínio e regras de negócio (`Biblioteca` concentra a lógica de empréstimo, devolução e busca)
- **services** — camada de interação com o usuário (menu e leitura de dados via console)

## Como executar

Pré-requisitos: Java 21 e Maven.

```bash
mvn compile
mvn exec:java -Dexec.mainClass="livraria.Main"
```

Ou execute a classe `Main` diretamente pela IDE.

## Menu

```
--MENU LIVRARIA--
1 - Ver livros disponíveis
2 - Realizar empréstimo
3 - Buscar por autor ou título
4 - Devolver livro
0 - Sair
```

## Observações

- O projeto já inicia com alguns livros e autores cadastrados para facilitar os testes.
- Não há persistência em banco de dados — os dados existem apenas durante a execução do programa.
