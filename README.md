# Google Livros
## Backend
Rest Api que utiliza Spring Boot e java 11.
O projeto frontend desta Api está em: https://github.com/danielps99/googlebooks_front_angular 

### Funcionalidades

1. Menus - Pesquisar / Favoritos (default)
2. Pesquisar livros no Google books e exibir em tela (com a foto, descrição e título do livro)
3. Salvar livros em uma lista de "meus favoritos" (localmente na base escolhida)
4. Permitir excluir livros favoritos
5. Exibir alerta de confirmaçao de exclusão

### Api Endpoint
#### Pesquisar livros
- http://localhost:8080/api/livro/listar?pesquisa=valorpesquisa&pagina=0&maxResultado=10
#### Adicionar livro aos favoritos
- http://localhost:8080/api/livro-favorito/criar
#### Pesquisar livro favoritos
- http://localhost:8080/api/livro-favorito/listar?pesquisa=valorpesquisa&pagina=0&maxResultado=10
#### Remover livro dos favoritos
- http://localhost:8080/api/livro-favorito/deletar/790f1033-24a6-433a-9cbb-0a303062a66e
  
### Requisitos para executar a aplicação
- Java 11
- Apache Maven 3.6.3

## Como executar aplicação
### Baixar dependências da aplicação
1. No diretorio do Projeto digite:
    - mvn install
### Executar aplicação
2. No diretorio do Projeto digite:
    - mvn spring-boot:run

## Detalhes sobre o desenvolvimento do projeto
Para cumprir os requisitos solicitados, não é necessario a utilizacao da anotatação @JsonAlias, mas escolhi expor uma api com variaveis em portugues.
### Facilidades
- Utilizar o Spring Boot facilitou criar, configurar e executar o projeto. O H2 Database remove a necessidade de instalar um banco no host.

### Dificuldades
- Por fazer alguns anos que não desenvolvo Rest api, tive que pesquisar um pouco para desenvolver as funcionalidades.

### Tempo para desenvolver
- Entre Pesquisa e desenvolvimento foram 18 horas.
