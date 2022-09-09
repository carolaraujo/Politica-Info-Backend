# Politica-Info-Backend

API Backend do Trabalho de Conclusão do Curso de Graduação em Análise e Desenvolvimento de Sistemas

## Como rodar a aplicação ?
1- Use o seu IDE de preferência

2 - Certifique de ter baixado o JDK/JRE 1.8 e o Tomcat

3 - Clique no botão direito do mouse em "run" em cima da classe PoliticaInfoApplication para rodar a aplicação

4 - Se preferir rodar por linha de comando digite no terminal mvn spring-boot:run

## Como testar a aplicação no Postman ?

URL para cadastrar um Usuario

POST => http://localhost:8080/usuarios

{
"nome": "Nome do usuario aqui",

"email": "emaildousuarioaqui@email.com"
}

URL para mostrar todos os usuarios cadastrados

GET => http://localhost:8080/usuarios

## Como visualizar os cadastros no Bando de Dados H2 ?

O banco de dados H2 é um database de homologação usando para testes em desenvolvimento, não precisa instalar nenhum software para poder visualizar as tabelas. 
Nessa apicação utilize a url abaixo em seu navegador de preferência

http://localhost:8080/h2

login: sa

passaword: (vazio)

