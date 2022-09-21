<h1 align="center">Politica-Info-Backend</h1>
<h4 align="center"> 
    :construction:  Projeto em construção  :construction:
</h4>

API Backend do Trabalho de Conclusão do Curso de Graduação em Análise e Desenvolvimento de Sistemas

## :hammer: Funcionalidades do projeto

- `Funcionalidade 1`: CRUD da tela de Login no Banco de Dados H2
- `Funcionalidade 2`: Consumo da API da Câmara dos Deputados
- `Funcionalidade 3`: Filtro dos endpoints da API da Câmara dos Deputados

## 🛠️ Abrir e rodar o projeto
1- Use o seu IDE de preferência

2 - Certifique de ter baixado o JDK/JRE 1.8 e o Tomcat

3 - Clique no botão direito do mouse em "run" em cima da classe PoliticaInfoApplication para rodar a aplicação

4 - Se preferir rodar por linha de comando digite no terminal mvn spring-boot:run

## 🛠️ Como testar a aplicação no Postman ?

URL para cadastrar um usuário

POST => http://localhost:8080/usuarios

{
"nome": "Nome do usuário aqui",

"email": "emaildousuarioaqui@email.com"
}

URL para mostrar todos os usuários cadastrados

GET => http://localhost:8080/usuarios

URL para buscar usuários por ID

GET => http://localhost:8080/usuarios/2

O ultimo número da URL é o ID que deseja buscar

URL para atualizar usuário 

PUT => http://localhost:8080/usuarios/2

O último número da URL é o ID que deseja atualizar

URL para deletar um usuário

DELETE => http://localhost:8080/usuarios/2

O último número da URL é o ID que deseja excluir

## 🛠️ Como visualizar os cadastros no Banco de Dados H2 ?

O banco de dados H2 é um database de homologação usando para testes em desenvolvimento, não precisa instalar nenhum software para poder visualizar as tabelas. 
Nessa apicação utilize a url abaixo em seu navegador de preferência

http://localhost:8080/h2

login: sa

passaword: (vazio)

