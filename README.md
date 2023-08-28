# Projeto de Gerenciamento de Empresas e Fornecedores

Este é um projeto de uma aplicação web desenvolvida com Angular no front-end e Spring Boot no back-end, que permite o gerenciamento de empresas e fornecedores. A aplicação permite a criação, edição, exclusão e associação de fornecedores às empresas.

## Principais Recursos e Funcionalidades

- **Cadastro de Empresas e Fornecedores:** O sistema permite cadastrar novas empresas e fornecedores, com informações detalhadas como CNPJ, nome fantasia, estado, email, data de nascimento, entre outros.

- **Associação de Empresas e Fornecedores:** É possível associar empresas a fornecedores e vice-versa, criando relações entre eles para melhor gerenciamento.

- **Filtros de Busca:** O sistema oferece a capacidade de filtrar empresas e fornecedores por diferentes critérios, como nome, CNPJ/CPF e estado.

- **Documentação da API com Swagger:** Utilizamos o [Swagger](https://swagger.io/) para documentar a API, facilitando a visualização e teste dos endpoints disponíveis, além de oferecer exemplos de requisições.

## Peculiaridades e Detalhes Técnicos

- **Front-end Angular:** Utilizamos o Angular como framework front-end, seguindo as melhores práticas de desenvolvimento para criar uma interface amigável e responsiva.

- **Back-end Spring Boot:** O back-end foi desenvolvido em Spring Boot, aproveitando seus recursos para criar uma API robusta e escalável.

- **Integração com Banco de Dados:** Fizemos a integração com um banco de dados PostgreSQL para armazenar as informações das empresas e fornecedores.

- **Validações Customizadas:** Implementamos validações personalizadas para garantir a consistência e integridade dos dados, como a validação de idade mínima para determinados estados.

## Fatos Relevantes

- **Utilização do Swagger:** Optamos por utilizar o Swagger para documentar a API, tornando mais fácil a exploração dos recursos disponíveis e a realização de testes.

- **Arquitetura MVC:** Seguimos o padrão arquitetural MVC (Model-View-Controller) para separar as responsabilidades e facilitar a manutenção do código.

## Próximos Passos

- **Melhorias na Interface:** Pretendemos aprimorar a interface do sistema, tornando-a mais intuitiva e agradável para os usuários.

- **Implementação de Autenticação e Autorização:** Para aumentar a segurança, planejamos adicionar autenticação e autorização aos endpoints da API.

## Tecnologias Utilizadas

- **Front-end:** Angular
- **Back-end:** Spring Boot (Java)
- **Banco de Dados:** PostgreSQL
- **Outras Ferramentas:** Spring Data JPA, Hibernate, HTML, CSS, TypeScript

## Funcionalidades

- Cadastro, edição e remoção de empresas
- Cadastro, edição e remoção de fornecedores
- Associação e desassociação de fornecedores às empresas
- Listagem de fornecedores associados a uma empresa
- Busca de fornecedores por nome ou CNPJ/CPF

## Configuração

1. Certifique-se de ter o Node.js e o Angular CLI instalados em sua máquina.
2. Importe o projeto do back-end (Spring Boot) em sua IDE preferida.
3. Configure as informações do banco de dados PostgreSQL no arquivo `application.properties`.
4. Execute a aplicação do back-end.
5. Acesse a pasta do front-end (Angular) pelo terminal.
6. Execute `npm install` para instalar as dependências.
7. Execute `ng serve` para iniciar o servidor de desenvolvimento do Angular.

## Acesso à Aplicação

Após seguir os passos acima, acesse a aplicação em seu navegador através do link: [http://localhost:4200](http://localhost:4200).

## Documentação da API com Swagger

Este projeto possui uma documentação da API integrada ao Swagger, uma ferramenta que facilita a visualização e interação com os endpoints da aplicação de forma amigável.

### Acesso ao Swagger

Após iniciar a aplicação do back-end, você pode acessar a documentação do Swagger em:

**URL:** [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Nessa página, você encontrará uma interface interativa que lista todos os endpoints disponíveis na API, juntamente com detalhes sobre os parâmetros, métodos HTTP, respostas e exemplos de requisições. Isso é especialmente útil para testar os endpoints da API e entender como interagir com eles.

Lembre-se de que a documentação do Swagger é gerada automaticamente com base nas anotações do Spring Boot presentes em seus controllers e serviços. Portanto, sempre mantenha suas anotações atualizadas para refletir corretamente a lógica da API.

## Autor

Marcos Vinícius Lins de Oliveira

## Licença

Este projeto está licenciado sob a Licença MIT. Veja o arquivo LICENSE para mais detalhes.
