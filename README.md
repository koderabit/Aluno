# Projeto Aluno MVC

Este é um projeto de exemplo que implementa uma aplicação simples de gerenciamento de alunos usando a arquitetura MVC (Model-View-Controller). O objetivo do projeto é demonstrar como separar as responsabilidades em diferentes camadas e promover a reutilização de código.

## Tecnologias utilizadas

- Linguagem: Java
- Biblioteca gráfica: Swing
- Banco de dados: PostgreSQL

## Funcionalidades

- Incluir novos alunos
- Consultar a lista de alunos cadastrados

## Arquitetura MVC

O projeto segue a arquitetura MVC, que divide a aplicação em três componentes principais:

- Model: Representa a camada de dados e lógica de negócio. Neste projeto, o model é representado pela classe Aluno e AlunoDAO.

- View: Responsável pela interface gráfica com o usuário. A classe AlunoView é responsável por exibir e interagir com os elementos visuais da aplicação.

- Controller: Gerencia a interação entre o Model e a View. A classe AlunoController é responsável por receber eventos da View e atualizar o Model de acordo.

## Como executar o projeto

1. Clone este repositório: `git clone https://github.com/koderabit/Aluno`
2. Importe o projeto em sua IDE Java preferida.
3. Certifique-se de ter o PostgreSQL instalado e configurado corretamente.
4. Crie um banco de dados chamado ESCOLA2 e execute o script SQL fornecido.
5. Execute a classe AlunoMain para iniciar a aplicação.

## Screenshots

Aqui estão dois screenshots do projeto em funcionamento:

